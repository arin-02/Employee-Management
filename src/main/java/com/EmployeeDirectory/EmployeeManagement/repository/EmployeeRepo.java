package com.EmployeeDirectory.EmployeeManagement.repository;

import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeSchema,Integer> {
    List<EmployeeSchema> findByDepartment(String department);

    List<EmployeeSchema> findByPosition(String position);
}
