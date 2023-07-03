package com.example.StreamAPIAndOptional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/departments")
public class EmployeeController implements EmployeeService {


    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/min-salary")
    @Override
    public Employee minimumSalary(@RequestParam("departmentId") int departmentId) {

        return employeeService.minimumSalary(departmentId);

    }

    @GetMapping("/max-salary")
    @Override
    public Employee maxSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.maxSalary(departmentId);
    }

    @GetMapping("/departmentsAll")
    @Override
    public ArrayList<Employee> departmentsAll(@RequestParam("departmentId") int departmentId) {
        return employeeService.departmentsAll(departmentId);
    }

    @GetMapping("/All")
    @Override
    public Map<Integer, List<Employee>> All() {
        return employeeService.All();
    }

    @GetMapping("/add")
    @Override
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("salary") int salary,
                        @RequestParam("departmentId") int departmentId) {

        return employeeService.add(firstName,lastName,salary,departmentId);
    }
}
