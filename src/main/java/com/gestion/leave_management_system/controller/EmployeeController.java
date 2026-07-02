package com.gestion.leave_management_system.controller;

import com.gestion.leave_management_system.model.Employee;
import com.gestion.leave_management_system.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


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

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
}
    
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        
        return employeeService.createEmployee(employee);
    }

    @PutMapping("employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("employees/{id}")
    public Employee deleteEmployee(@PathVariable Long id) {
        
        return employeeService.deleteEmployee(id);
    }

    

}