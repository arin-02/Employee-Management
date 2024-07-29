package com.EmployeeDirectory.EmployeeManagement.repository;

import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeSchema,Integer> {
    List<EmployeeSchema> findByDepartment(String department);

    @Query(value = "SELECT * FROM Employee_Table WHERE position = :position", nativeQuery = true)
    List<EmployeeSchema> findByPositionCustom(@Param("position") String position);

}
