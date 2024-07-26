package com.EmployeeDirectory.EmployeeManagement.service;

import com.EmployeeDirectory.EmployeeManagement.repository.EmployeeRepo;
import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {


     List<EmployeeSchema> getAllEmployees();

     void addEmployees(EmployeeSchema employeeSchema);

     void deleteEmployeeById(int id);

     void updateEmployeeById(EmployeeSchema newempSchema,int id);

     List<EmployeeSchema> getEmployeesByDepartment(String department);

     List<EmployeeSchema> getEmployeesByPosition(String position);
}
