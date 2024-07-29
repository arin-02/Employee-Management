package com.EmployeeDirectory.EmployeeManagement.dao.daoImpl;

import com.EmployeeDirectory.EmployeeManagement.dao.EmployeeDao;
import com.EmployeeDirectory.EmployeeManagement.exception.EmployeeNotFoundException;
import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import com.EmployeeDirectory.EmployeeManagement.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    public EmployeeRepo employeeRepo;

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
//    @Override
//    public List<EmployeeSchema> getEmployeesByDepartment(String department) {
//        return employeeRepo.findByDepartment(department);
//    }
//
//    @Override
//    public List<EmployeeSchema> getEmployeesByPosition(String position) {
//        return employeeRepo.findByPositionCustom(position);
//    }

    @Override
    public EmployeeSchema saveData(EmployeeSchema employeeSchema) {

        return employeeRepo.save(employeeSchema);
    }

    @Override
    public List<EmployeeSchema> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public boolean existsById(int id) {
        return employeeRepo.existsById(id);
    }


    @Override
    public void deleteById(int id) {
        if (!employeeRepo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        employeeRepo.deleteById(id);
    }

    @Override
    public void save(EmployeeSchema newempSchema) {
            employeeRepo.save(newempSchema);
    }

    @Override
    public List<EmployeeSchema> findByDepartment(String department) {
        return employeeRepo.findByDepartment(department);
    }

    @Override
    public List<EmployeeSchema> findByPositionCustom(String position) {
        return employeeRepo.findByPositionCustom(position);
    }


}
