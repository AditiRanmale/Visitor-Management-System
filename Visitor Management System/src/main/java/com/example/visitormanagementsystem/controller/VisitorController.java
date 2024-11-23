package com.example.visitormanagementsystem.controller;

import com.example.visitormanagementsystem.model.Visitor;
import com.example.visitormanagementsystem.service.VisitorService;
import com.example.visitormanagementsystem.service.HostService;  // Import the HostService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private HostService hostService; // Add this line to inject the HostService

    // Show form to register a visitor
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("visitor", new Visitor());
        model.addAttribute("hosts", hostService.getAllHosts());  // Fetch list of hosts
        return "visitor_register"; // Return the registration form template
    }

    // Handle visitor registration
    @PostMapping("/register")
    public String registerVisitor(@ModelAttribute Visitor visitor) {
        visitorService.saveVisitor(visitor); // Save the visitor
        return "redirect:/visitor/registration-success"; // Redirect to the success page after registration
    }

    // Show all visitors
    @GetMapping("/list")
    public String listVisitors(Model model) {
        model.addAttribute("visitors", visitorService.getAllVisitors());
        return "visitor_list"; // The name of your Thymeleaf template for displaying visitors
    }

    // Edit visitor (GET request to show the form)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Visitor visitor = visitorService.getVisitorById(id);
        if (visitor != null) {
            model.addAttribute("visitor", visitor);
            return "edit_visitor"; // Name of the edit form template
        } else {
            return "redirect:/visitor/list"; // Redirect to the visitor list if not found
        }
    }

    // Edit visitor (POST request to update)
    @PostMapping("/edit/{id}")
    public String updateVisitor(@PathVariable("id") Long id, @ModelAttribute("visitor") Visitor visitor) {
        visitorService.saveVisitor(visitor); // Save updated visitor
        return "redirect:/visitor/list"; // Redirect to the list page after saving
    }

    // Check-in visitor
    @GetMapping("/checkin/{id}")
    public String checkInVisitor(@PathVariable("id") Long id) {
        visitorService.checkInVisitor(id); // Call service method for check-in
        return "redirect:/visitor/list"; // Redirect to list after check-in
    }

    // Check-out visitor
    @GetMapping("/checkout/{id}")
    public String checkOutVisitor(@PathVariable("id") Long id) {
        visitorService.checkOutVisitor(id); // Call service method for check-out
        return "redirect:/visitor/list"; // Redirect to list after check-out
    }

    // Delete visitor (optional)
    @GetMapping("/delete/{id}")
    public String deleteVisitor(@PathVariable("id") Long id) {
        visitorService.deleteVisitorById(id); // Call service method for delete
        return "redirect:/visitor/list"; // Redirect to list after deletion
    }

    // Show registration success page
    @GetMapping("/registration-success")
    public String showRegistrationSuccess() {
        return "registration_success"; // Return the success page template
    }
}
