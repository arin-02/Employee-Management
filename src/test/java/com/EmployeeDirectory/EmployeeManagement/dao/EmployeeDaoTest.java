//package com.EmployeeDirectory.EmployeeManagement.dao;
//
//import com.EmployeeDirectory.EmployeeManagement.dao.daoImpl.EmployeeDaoImpl;
//import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
//import com.EmployeeDirectory.EmployeeManagement.repository.EmployeeRepo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
//
//public class EmployeeDaoTest {
//
//
//    @InjectMocks
//    private EmployeeDaoImpl employeeDao; // Assuming EmployeeDaoImpl is your DAO implementation
//
//    @Mock
//    private EmployeeRepo employeeRepo;
//
//
//
//    @BeforeEach
//    public void setUp() {
//        employeeDao = new EmployeeDaoImpl(employeeRepo);
//    }
//
//
//    @Test
//    public void testSaveData() {
//        // Arrange
//        when(employeeRepo.save(any(EmployeeSchema.class))).thenReturn(employeeSchema);
//
//        // Act
//        EmployeeSchema savedEmployee = employeeDao.saveData(employeeSchema);
//
//        // Assert
//        assertEquals(employeeSchema, savedEmployee); // Ensure EmployeeSchema overrides equals and hashCode methods
//        verify(employeeRepo, times(1)).save(employeeSchema);
//    }
//
//
//
//
//}
