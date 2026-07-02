package com.gestion.leave_management_system.controller;

import com.gestion.leave_management_system.model.LeaveRequest;
import com.gestion.leave_management_system.service.LeaveRequestService;
import org.springframework.web.bind.annotation.*;

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
}
