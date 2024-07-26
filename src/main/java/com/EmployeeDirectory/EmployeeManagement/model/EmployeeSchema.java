package com.EmployeeDirectory.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Employee_Table")
//@Getter
//@Setter
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

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContact_Details() {
        return contact_Details;
    }

    public void setContact_Details(String contact_Details) {
        this.contact_Details = contact_Details;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
