package com.EmployeeDirectory.EmployeeManagement.dao;

import com.EmployeeDirectory.EmployeeManagement.dao.daoImpl.EmployeeDaoImpl;
import com.EmployeeDirectory.EmployeeManagement.exception.EmployeeNotFoundException;
import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import com.EmployeeDirectory.EmployeeManagement.repository.EmployeeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @MockBean
    private EmployeeRepo employeeRepo;


    public static List<EmployeeSchema> employeeList;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
        employeeList = List.of(
                new EmployeeSchema(3, "lucky", "new_pos", "dept", "aaaa@gmail.com"),
                new EmployeeSchema(324, "arin2", "ytl_pos", "acq_dept", "a@gmail.com")
        );
    }


    @Test
    public void testSaveData() {

        EmployeeSchema employee = employeeList.get(0);
        when(employeeRepo.save(any(EmployeeSchema.class))).thenReturn(employee);


        EmployeeSchema savedEmployee = employeeDao.saveData(employee);


        Assertions.assertNotNull(savedEmployee);
        Assertions.assertEquals(employee.getEmpId(), savedEmployee.getEmpId());
        Assertions.assertEquals(employee.getName(), savedEmployee.getName());
        Assertions.assertEquals(employee.getPosition(), savedEmployee.getPosition());
        Assertions.assertEquals(employee.getDepartment(), savedEmployee.getDepartment());
        Assertions.assertEquals(employee.getContact_Details(), savedEmployee.getContact_Details());
    }

    @Test
    public void testFindAll() {
        when(employeeRepo.findAll()).thenReturn(employeeList);

        List<EmployeeSchema> employees = employeeDao.findAll();

        Assertions.assertNotNull(employees);
        Assertions.assertEquals(2, employees.size());
        Assertions.assertEquals(employeeList.get(0), employees.get(0));
        Assertions.assertEquals(employeeList.get(1), employees.get(1));
    }

    @Test
    public void testExistsById() {
        when(employeeRepo.existsById(anyInt())).thenReturn(true);

        boolean exists = employeeDao.existsById(1);

        Assertions.assertTrue(exists);
    }

    @Test
    public void testDeleteByIdWhenEmployeeExists() {
        when(employeeRepo.existsById(anyInt())).thenReturn(true);

        employeeDao.deleteById(1);

        verify(employeeRepo, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteByIdWhenEmployeeDoesNotExist() {
        when(employeeRepo.existsById(anyInt())).thenReturn(false);

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeDao.deleteById(1);
        });
    }

    @Test
    public void testSave() {
        EmployeeSchema employee = employeeList.get(0);
        when(employeeRepo.save(any(EmployeeSchema.class))).thenReturn(employee);

        employeeDao.save(employee);

        verify(employeeRepo, times(1)).save(employee);
    }

    @Test
    public void testFindByDepartment() {
        when(employeeRepo.findByDepartment(anyString())).thenReturn(employeeList);

        List<EmployeeSchema> employees = employeeDao.findByDepartment("dept");

        Assertions.assertNotNull(employees);
        Assertions.assertEquals(2, employees.size());
    }

    @Test
    public void testFindByPositionCustom() {
        when(employeeRepo.findByPositionCustom(anyString())).thenReturn(employeeList);

        List<EmployeeSchema> employees = employeeDao.findByPositionCustom("newpos");

        Assertions.assertNotNull(employees);
        Assertions.assertEquals(2, employees.size());
    }
}



