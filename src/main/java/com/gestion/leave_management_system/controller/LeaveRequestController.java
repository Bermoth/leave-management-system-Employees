package com.gestion.leave_management_system.controller;

import com.gestion.leave_management_system.model.LeaveRequest;
import com.gestion.leave_management_system.service.LeaveRequestService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;


@RestController
@RequestMapping("/leaves")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping
    public ResponseEntity<LeaveRequest> createLeave(@RequestParam Long employeeId, @RequestBody LeaveRequest leaveRequest) {
        LeaveRequest createdLeave = leaveRequestService.createLeave(employeeId, leaveRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeave);
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

    @DeleteMapping("/{id}")
    public String deleteLeave(@PathVariable Long id) {
        leaveRequestService.deleteLeave(id);
        return  "Leave request deleted successfully";
    }


}
