package com.example.StreamAPIAndOptional;

import java.util.Objects;


public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int departmentId;

    public Employee(String firstName, String lastName, int salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return departmentId;
    }
}
