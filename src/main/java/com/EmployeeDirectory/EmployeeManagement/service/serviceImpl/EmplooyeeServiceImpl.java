package com.EmployeeDirectory.EmployeeManagement.service.serviceImpl;

import com.EmployeeDirectory.EmployeeManagement.dao.EmployeeDao;
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
    private EmployeeDao employeeDao;

    public List<EmployeeSchema> getAllEmployees()
    {
//        List<EmployeeSchema> emps=(List<EmployeeSchema>) employeeDao.findAll();
//        System.out.println("list of all employees----------> "+emps);
//        return emps;
        return employeeDao.findAll();
    }

    public void addEmployees(EmployeeSchema employeeSchema)
    {
        employeeDao.saveData(employeeSchema);
    }

    public void deleteEmployeeById(int id)
    {
        if (!employeeDao.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        employeeDao.deleteById(id);
    }

    public void updateEmployeeById(EmployeeSchema newempSchema,int id)
    {
        if (!employeeDao.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
//        if(id==newempSchema.getEmpId())
//        {
//            employeeRepo.save(newempSchema);
//        }
        newempSchema.setEmpId(id);
        employeeDao.save(newempSchema);
    }
    @Override
    public List<EmployeeSchema> getEmployeesByDepartment(String department) {
        return employeeDao.findByDepartment(department);
    }

    @Override
    public List<EmployeeSchema> getEmployeesByPosition(String position) {
        return employeeDao.findByPositionCustom(position);
    }



}
