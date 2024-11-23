package com.example.visitormanagementsystem.service;

import com.example.visitormanagementsystem.model.Host;
import com.example.visitormanagementsystem.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Ensure this annotation is present
public class HostService {

    @Autowired
    private HostRepository hostRepository;

    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }
}