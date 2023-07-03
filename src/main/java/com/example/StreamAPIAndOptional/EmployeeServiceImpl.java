package com.example.StreamAPIAndOptional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> staff = new ArrayList<>(List.of(
            new Employee("Чернов", "Данила", 60_000, 2),
            new Employee("Григорьев", "Олег", 50_000, 4),
            new Employee("Беляев", "Максим", 70_000, 2),
            new Employee("Александров", "Кирилл", 90_000, 1)
    ));

    @Override
    public Employee minimumSalary(int departmentId) {
        return staff.stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public Employee maxSalary(int departmentId) {
        return staff.stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public ArrayList<Employee> departmentsAll(int departmentId) {
        return (ArrayList<Employee>) staff
                .stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .collect(Collectors.toList());

    }

    @Override
    public Map<Integer, List<Employee>> All() {
        return staff
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        if (!StringUtils.isAlpha(firstName) && !StringUtils.isAlpha(lastName)) {
            throw
                    new RuntimeException();
        }
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        staff.add(employee);
        return employee;
    }

}