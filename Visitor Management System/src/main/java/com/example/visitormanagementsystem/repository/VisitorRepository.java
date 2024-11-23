package com.example.visitormanagementsystem.repository;

import com.example.visitormanagementsystem.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    List<Visitor> findByHostId(Long hostId); // Custom query to find visitors by host ID
}
