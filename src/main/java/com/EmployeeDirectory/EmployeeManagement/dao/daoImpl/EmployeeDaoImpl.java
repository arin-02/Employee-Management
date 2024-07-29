package com.EmployeeDirectory.EmployeeManagement.dao.daoImpl;

import com.EmployeeDirectory.EmployeeManagement.dao.EmployeeDao;
import com.EmployeeDirectory.EmployeeManagement.exception.EmployeeNotFoundException;
import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import com.EmployeeDirectory.EmployeeManagement.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDaoImpl implements EmployeeDao {


    public EmployeeDaoImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Autowired
    public EmployeeRepo employeeRepo;

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
