package com.EmployeeDirectory.EmployeeManagement.service;


import com.EmployeeDirectory.EmployeeManagement.controller.Employee;
import com.EmployeeDirectory.EmployeeManagement.dao.EmployeeDao;
import com.EmployeeDirectory.EmployeeManagement.exception.EmployeeNotFoundException;
import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

    public static List<EmployeeSchema> employeeList;


    @Autowired
    public EmployeeService employeeService;

    @MockBean
    public EmployeeDao employeeDao;

    @BeforeEach
    public void setUp() {
        employeeList = List.of(
                new EmployeeSchema(3, "lucky", "newpos", "dept", "aaaa@gmail.com"),
                new EmployeeSchema(324, "arin2", "ytlpos", "acqdept", "a@gmail.com")
        );
    }


    @Test
    public void testGetAllEmployees()
    {
        // Arrange
        when(employeeDao.findAll()).thenReturn(employeeList);

        // Act
        List<EmployeeSchema> employees = employeeService.getAllEmployees();

        // Assert
        assertEquals(employeeList, employees);
    }

    @Test
    public void testAddEmployee() {
        // Arrange
        EmployeeSchema newEmployee = new EmployeeSchema(100, "newbie", "newpos", "dept", "newbie@gmail.com");

        // Act
        employeeService.addEmployees(newEmployee);

        // Assert
        verify(employeeDao).saveData(newEmployee);
    }

    @Test
    public void testDeleteEmployeeById_Success() {
        // Arrange
        int idToDelete = 3;
        when(employeeDao.existsById(idToDelete)).thenReturn(true);

        // Act
        employeeService.deleteEmployeeById(idToDelete);

        // Assert
        verify(employeeDao).deleteById(idToDelete);
    }

    @Test
    public void testDeleteEmployeeById_NotFound() {
        // Arrange
        int idToDelete = 999;
        when(employeeDao.existsById(idToDelete)).thenReturn(false);

        // Act & Assert
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.deleteEmployeeById(idToDelete);
        });
        assertEquals("Employee with ID 999 not found", exception.getMessage());
    }

    @Test
    public void testUpdateEmployeeById_Success() {
        // Arrange
        EmployeeSchema updatedEmployee = new EmployeeSchema(3, "updated", "updatedpos", "updateddept", "updated@gmail.com");
        int idToUpdate = 3;
        when(employeeDao.existsById(idToUpdate)).thenReturn(true);

        // Act
        employeeService.updateEmployeeById(updatedEmployee, idToUpdate);

        // Assert
        verify(employeeDao).save(updatedEmployee);
    }

    @Test
    public void testUpdateEmployeeById_NotFound() {
        // Arrange
        EmployeeSchema updatedEmployee = new EmployeeSchema(999, "updated", "updatedpos", "updateddept", "updated@gmail.com");
        int idToUpdate = 999;
        when(employeeDao.existsById(idToUpdate)).thenReturn(false);

        // Act & Assert
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.updateEmployeeById(updatedEmployee, idToUpdate);
        });
        assertEquals("Employee with ID 999 not found", exception.getMessage());
    }

    @Test
    public void testGetEmployeesByDepartment() {
        // Arrange
        String department = "dept";
        when(employeeDao.findByDepartment(department)).thenReturn(employeeList);

        // Act
        List<EmployeeSchema> employees = employeeService.getEmployeesByDepartment(department);

        // Assert
        assertEquals(employeeList, employees);
    }

    @Test
    public void testGetEmployeesByPosition() {
        // Arrange
        String position = "newpos";
        when(employeeDao.findByPositionCustom(position)).thenReturn(employeeList);

        // Act
        List<EmployeeSchema> employees = employeeService.getEmployeesByPosition(position);

        // Assert
        assertEquals(employeeList, employees);
    }

}
