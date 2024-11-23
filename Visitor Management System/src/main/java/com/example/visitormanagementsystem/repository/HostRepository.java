package com.example.visitormanagementsystem.repository;

import com.example.visitormanagementsystem.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {
}
