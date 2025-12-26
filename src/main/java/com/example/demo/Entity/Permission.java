package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Permission {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String permissionKey;

    private String description;
    private boolean active = true;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPermissionKey() { return permissionKey; }
    public void setPermissionKey(String key) { this.permissionKey = key; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }
}
