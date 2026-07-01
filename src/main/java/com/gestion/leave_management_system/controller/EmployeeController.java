package com.gestion.leave_management_system.controller;

import com.gestion.leave_management_system.model.Employee;
import com.gestion.leave_management_system.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        
        return employeeService.createEmployee(employee);
    }

}