package com.example.demo.controller;

import com.example.demo.entity.RoleEntity;
import com.example.demo.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public RoleEntity createRole(@RequestBody RoleEntity role) {
        return roleService.createRole(role);
    }

    @PutMapping("/{id}")
    public RoleEntity updateRole(@PathVariable Long id, @RequestBody RoleEntity role) {
        return roleService.updateRole(id, role);
    }

    @GetMapping("/{id}")
    public RoleEntity getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @GetMapping
    public List<RoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/{id}/deactivate")
    public String deactivateRole(@PathVariable Long id) {
        roleService.deactivateRole(id);
        return "Role deactivated successfully";
    }
}
