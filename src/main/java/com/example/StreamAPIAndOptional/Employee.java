package com.example.StreamAPIAndOptional;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;


public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int departmentId;

    public Employee(String firstName, String lastName, int salary, int department) {
        this.firstName = StringUtils.capitalize(StringUtils.trim(firstName.toLowerCase()));
        this.lastName = StringUtils.capitalize(StringUtils.trim(lastName.toLowerCase()));
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
