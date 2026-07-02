package com.gestion.leave_management_system.repository;


import com.gestion.leave_management_system.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    
}
