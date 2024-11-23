package com.example.visitormanagementsystem.controller;

import com.example.visitormanagementsystem.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private VisitorService visitorService;

    // View all visitors
    @GetMapping("/all-visitors")
    public String viewAllVisitors(Model model) {
        model.addAttribute("visitors", visitorService.getAllVisitors());
        return "admin_visitor_list";
    }
}
