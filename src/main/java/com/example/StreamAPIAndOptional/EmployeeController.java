package com.example.StreamAPIAndOptional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public ArrayList<Employee> All() {
        return employeeService.All();
    }
}
