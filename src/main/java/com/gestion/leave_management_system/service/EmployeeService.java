package com.gestion.leave_management_system.service;

import com.gestion.leave_management_system.model.Employee;
import com.gestion.leave_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee == null) {
            return null;
        }

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setAddress(updatedEmployee.getAddress());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
        employee.setRole(updatedEmployee.getRole());

        return employeeRepository.save(employee);
    }

    public Employee deleteEmployee(Long id) {
        Employee employeeToDelete = employeeRepository.findById(id).orElse(null);

        if (employeeToDelete == null) {
            return null;
        }

        employeeRepository.delete(employeeToDelete);
        return employeeToDelete;
    }
}

