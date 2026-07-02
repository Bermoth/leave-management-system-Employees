package com.gestion.leave_management_system.service;

import com.gestion.leave_management_system.model.LeaveRequest;
import com.gestion.leave_management_system.model.LeaveStatus;
import com.gestion.leave_management_system.model.Employee;
import com.gestion.leave_management_system.repository.LeaveRequestRepository;
import com.gestion.leave_management_system.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LeaveRequestService {
    private final EmployeeRepository employeeRepository;
    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestService (EmployeeRepository employeeRepository,
        LeaveRequestRepository leaveRequestRepository) {
            this.employeeRepository = employeeRepository;
            this.leaveRequestRepository = leaveRequestRepository;
    }

    public LeaveRequest createLeave(Long employeeId, LeaveRequest leaveRequest) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            return null;
        }
        leaveRequest.setEmployee(employee);
        leaveRequest.setStatus(LeaveStatus.PENDING);

        return leaveRequestRepository.save(leaveRequest);
    }

    public List<LeaveRequest> getAllLeaves() {
        return leaveRequestRepository.findAll();
    }

    public List<LeaveRequest> getLeaveById(Long id) {
        return leaveRequestRepository.findByEmployeeId(id);
    }

    public LeaveRequest updateStatus(Long id, String status) {

        LeaveRequest leave = leaveRequestRepository.findById(id).orElse(null);
        if (leave == null) {
            return null;
        }
        leave.setStatus(LeaveStatus.valueOf(status.toUpperCase()));
        return leaveRequestRepository.save(leave);
    }
}
