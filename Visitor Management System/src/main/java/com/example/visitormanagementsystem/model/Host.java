package com.example.visitormanagementsystem.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String department;

    @OneToMany(mappedBy = "host")
    private List<Visitor> visitors;

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<Visitor> getVisitors() { return visitors; }
    public void setVisitors(List<Visitor> visitors) { this.visitors = visitors; }
}
