package com.EmployeeDirectory.EmployeeManagement.dao;

import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;

import java.util.List;

public interface EmployeeDao {

    EmployeeSchema saveData(EmployeeSchema employeeSchema);

    List<EmployeeSchema> findAll();

    boolean existsById(int id);

    void deleteById(int id);

    void save(EmployeeSchema newempSchema);

    List<EmployeeSchema> findByDepartment(String department);

    List<EmployeeSchema> findByPositionCustom(String position);
}
