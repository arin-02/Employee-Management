package com.EmployeeDirectory.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "Employee_Table")

//@NoArgsConstructor
//@AllArgsConstructor
public class EmployeeSchema {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;

    private String name;
    private String position;
    private String department;
    private String contact_Details;

    public EmployeeSchema() {
    }

    public EmployeeSchema(int empId, String name, String position, String department, String contact_Details) {
        this.empId = empId;
        this.name = name;
        this.position = position;
        this.department = department;
        this.contact_Details = contact_Details;
    }



    @Override
    public String toString() {
        return "EmployeeSchema{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", Department='" + department + '\'' +
                ", Contact_Details='" + contact_Details + '\'' +
                '}';
    }


}