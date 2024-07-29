package com.EmployeeDirectory.EmployeeManagement.controller;

import com.EmployeeDirectory.EmployeeManagement.service.EmployeeService;
import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Employee.class) // Focus on the EmployeeController
public class EmployeeTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    private EmployeeSchema employeeSchema;
    private List<EmployeeSchema> employeeList;

    @BeforeEach
    public void setUp() {
        employeeSchema = new EmployeeSchema(12, "arin_singh", "Developer", "ITYTL", "ar@gmail.com");
        employeeList = List.of(employeeSchema);
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        // Arrange
        when(employeeService.getAllEmployees()).thenReturn(employeeList);

        // Act & Assert
        mockMvc.perform(get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].empId").value(employeeSchema.getEmpId()))
                .andExpect(jsonPath("$[0].name").value(employeeSchema.getName()))
                .andExpect(jsonPath("$[0].position").value(employeeSchema.getPosition()))
                .andExpect(jsonPath("$[0].department").value(employeeSchema.getDepartment()))
                .andExpect(jsonPath("$[0].contact_Details").value(employeeSchema.getContact_Details()));
    }

    @Test
    public void testAddEmployee() throws Exception {
        // Arrange
        doNothing().when(employeeService).addEmployees(any(EmployeeSchema.class));

        // Act & Assert
        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeSchema)))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).addEmployees(any(EmployeeSchema.class));
    }

    @Test
    public void testDeleteEmployeeById() throws Exception {
        // Arrange
        doNothing().when(employeeService).deleteEmployeeById(anyInt());

        // Act & Assert
        mockMvc.perform(delete("/employees/{id}", 12)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).deleteEmployeeById(12);
    }

    @Test
    public void testUpdateEmployee() throws Exception {
        // Arrange
        doNothing().when(employeeService).updateEmployeeById(any(EmployeeSchema.class), anyInt());

        // Act & Assert
        mockMvc.perform(put("/employees/{id}", 12)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeSchema)))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).updateEmployeeById(any(EmployeeSchema.class), anyInt());
    }

    @Test
    public void testGetEmployeesByDepartment() throws Exception {
        // Arrange
        when(employeeService.getEmployeesByDepartment(any(String.class))).thenReturn(employeeList);

        // Act & Assert
        mockMvc.perform(get("/filter/department/{department}", "ITYTL")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].empId").value(employeeSchema.getEmpId()))
                .andExpect(jsonPath("$[0].name").value(employeeSchema.getName()))
                .andExpect(jsonPath("$[0].position").value(employeeSchema.getPosition()))
                .andExpect(jsonPath("$[0].department").value(employeeSchema.getDepartment()))
                .andExpect(jsonPath("$[0].contact_Details").value(employeeSchema.getContact_Details()));
    }

    @Test
    public void testGetEmployeesByPosition() throws Exception {
        // Arrange
        when(employeeService.getEmployeesByPosition(any(String.class))).thenReturn(employeeList);

        // Act & Assert
        mockMvc.perform(get("/filter/position/{position}", "Developer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].empId").value(employeeSchema.getEmpId()))
                .andExpect(jsonPath("$[0].name").value(employeeSchema.getName()))
                .andExpect(jsonPath("$[0].position").value(employeeSchema.getPosition()))
                .andExpect(jsonPath("$[0].department").value(employeeSchema.getDepartment()))
                .andExpect(jsonPath("$[0].contact_Details").value(employeeSchema.getContact_Details()));
    }
}
