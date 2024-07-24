package com.EmployeeDirectory.EmployeeManagement.Repository;

import com.EmployeeDirectory.EmployeeManagement.model.EmployeeSchema;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<EmployeeSchema,Integer> {

}
