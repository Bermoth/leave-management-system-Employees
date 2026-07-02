package com.gestion.leave_management_system.controller;

import com.gestion.leave_management_system.model.LeaveRequest;
import com.gestion.leave_management_system.service.LeaveRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/leaves")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping
    public LeaveRequest createLeave(@RequestParam Long employeeId, @RequestBody LeaveRequest leaveRequest) {

        return leaveRequestService.createLeave(employeeId, leaveRequest);
    }

    @GetMapping
    public List<LeaveRequest> getAllLeaves() {
        return leaveRequestService.getAllLeaves();
    }

    @GetMapping("employee/{id}")
    public List<LeaveRequest> getLeavesByEmployee(@PathVariable Long id) {

        return leaveRequestService.getLeaveById(id);
    }

    @PutMapping("/{id}")
    public LeaveRequest updateStatus(@PathVariable Long id, @RequestParam String status) {

    return leaveRequestService.updateStatus(id, status);
    }
    
    
}
