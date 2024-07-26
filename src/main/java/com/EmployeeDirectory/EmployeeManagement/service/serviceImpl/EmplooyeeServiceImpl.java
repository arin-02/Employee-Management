package com.EmployeeDirectory.EmployeeManagement.service.serviceImpl;

import com.EmployeeDirectory.EmployeeManagement.exception.EmployeeNotFoundException;
import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import com.EmployeeDirectory.EmployeeManagement.repository.EmployeeRepo;
import com.EmployeeDirectory.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmplooyeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<EmployeeSchema> getAllEmployees()
    {
        List<EmployeeSchema> emps=(List<EmployeeSchema>) employeeRepo.findAll();
        return emps;
    }

    public void addEmployees(EmployeeSchema employeeSchema)
    {
        employeeRepo.save(employeeSchema);
    }

    public void deleteEmployeeById(int id)
    {
        if (!employeeRepo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        employeeRepo.deleteById(id);
    }

    public void updateEmployeeById(EmployeeSchema newempSchema,int id)
    {
        if (!employeeRepo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
//        if(id==newempSchema.getEmpId())
//        {
//            employeeRepo.save(newempSchema);
//        }
        newempSchema.setEmpId(id);
        employeeRepo.save(newempSchema);
    }
    @Override
    public List<EmployeeSchema> getEmployeesByDepartment(String department) {
        return employeeRepo.findByDepartment(department);
    }

    @Override
    public List<EmployeeSchema> getEmployeesByPosition(String position) {
        return employeeRepo.findByPosition(position);
    }


}
