package com.example.demo.controller;

import com.example.demo.entity.RolePermission;
import com.example.demo.service.RolePermissionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/role-permissions")
public class RolePermissionController {

    private final RolePermissionService service;

    public RolePermissionController(RolePermissionService service) {
        this.service = service;
    }

    @PostMapping
    public RolePermission grant(@RequestBody RolePermission rp) {
        return service.grantPermission(rp);
    }

    @GetMapping("/{id}")
    public RolePermission get(@PathVariable Long id) {
        return service.getMappingById(id);
    }

    @GetMapping("/role/{roleId}")
    public List<RolePermission> getForRole(@PathVariable Long roleId) {
        return service.getPermissionsForRole(roleId);
    }

    @DeleteMapping("/{id}")
    public String revoke(@PathVariable Long id) {
        service.revokePermission(id);
        return "Revoked";
    }
}
