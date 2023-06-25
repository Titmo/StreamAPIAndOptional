package com.example.StreamAPIAndOptional;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int id = 10;
    List<Employee> staff = new ArrayList<>(List.of(
            new Employee("Чернов", "Данила", 60_000, 2),
            new Employee("Григорьев", "Олег", 50_000, 4),
            new Employee("Беляев", "Максим", 70_000, 2),
            new Employee("Александров", "Кирилл", 90_000, 1)
    ));

    @Override
    public Employee minimumSalary(int departmentId) {
        ArrayList<Employee> findedList = (ArrayList<Employee>) staff
                .stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .collect(Collectors.toList());
        int salary = findedList.get(0).getSalary();
        int id=0;
        for (int i = 0; i < findedList.size(); i++) {
            if (findedList.get(i).getSalary() < salary) {
                salary=findedList.get(i).getSalary();
                id=i;
            }
        }

        return findedList.get(id);
    }

    @Override
    public Employee maxSalary(int departmentId) {
        ArrayList<Employee> findedList = (ArrayList<Employee>) staff
                .stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .collect(Collectors.toList());

        int salary = findedList.get(0).getSalary();
        int id=0;
        for (int i = 0; i < findedList.size(); i++) {
            if (findedList.get(i).getSalary() > salary) {
                salary=findedList.get(i).getSalary();
                id=i;
            }
        }

        return findedList.get(id);
    }

    @Override
    public ArrayList<Employee> departmentsAll(int departmentId) {
        ArrayList<Employee> findedList = (ArrayList<Employee>) staff
                .stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .collect(Collectors.toList());
        return findedList;
    }

    @Override
    public ArrayList<Employee> All() {
        return (ArrayList<Employee>) staff;
    }

}