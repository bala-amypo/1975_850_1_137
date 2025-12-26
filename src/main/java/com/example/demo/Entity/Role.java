package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String roleName;

    private String description;
    private boolean active = true;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String name) { this.roleName = name; }

    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
