package com.EmployeeDirectory.EmployeeManagement.controller;

import com.EmployeeDirectory.EmployeeManagement.service.EmployeeService;
import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Employee {

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/employees")
    public List<EmployeeSchema> getAllEmployee()
    {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public void addEmployees(@RequestBody EmployeeSchema employeeSchema)
    {
        employeeService.addEmployees(employeeSchema);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable int id)
    {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployees(@RequestBody EmployeeSchema newemployeeSchema,@PathVariable int id)
    {
    employeeService.updateEmployeeById(newemployeeSchema,id);
    }

    @GetMapping("/filter/department/{department}")
    public List<EmployeeSchema> getEmployeesByDepartment(@PathVariable String department) {
        return employeeService.getEmployeesByDepartment(department);
    }

    @GetMapping("/filter/position/{position}")
    public List<EmployeeSchema> getEmployeesByPosition(@PathVariable String position) {
        return employeeService.getEmployeesByPosition(position);
    }

}
