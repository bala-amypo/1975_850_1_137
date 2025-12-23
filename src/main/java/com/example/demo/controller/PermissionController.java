package com.example.demo.controller;

import com.example.demo.entity.PermissionEntity;
import com.example.demo.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    public PermissionEntity createPermission(@RequestBody PermissionEntity permission) {
        return permissionService.createPermission(permission);
    }

    @PutMapping("/{id}")
    public PermissionEntity updatePermission(@PathVariable Long id, @RequestBody PermissionEntity permission) {
        return permissionService.updatePermission(id, permission);
    }

    @GetMapping("/{id}")
    public PermissionEntity getPermissionById(@PathVariable Long id) {
        return permissionService.getPermissionById(id);
    }

    @GetMapping
    public List<PermissionEntity> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @PutMapping("/{id}/deactivate")
    public String deactivatePermission(@PathVariable Long id) {
        permissionService.deactivatePermission(id);
        return "Permission deactivated successfully";
    }
}
