package com.example.visitormanagementsystem.controller;

import com.example.visitormanagementsystem.service.VisitorService;  // Correct import for VisitorService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/host")
public class HostController {

    @Autowired
    private VisitorService visitorService;

    // View visitors for a particular host
    @GetMapping("/visitors/{hostId}")
    public String viewHostVisitors(@PathVariable("hostId") Long hostId, Model model) {
        model.addAttribute("visitors", visitorService.getVisitorsByHost(hostId));
        return "host_visitors";
    }
}
