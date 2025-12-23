package com.example.demo.service;

import com.example.demo.entity.PermissionEntity;

import java.util.List;

public interface PermissionService {

    PermissionEntity createPermission(PermissionEntity permission);

    PermissionEntity updatePermission(Long id, PermissionEntity permission);

    PermissionEntity getPermissionById(Long id);

    List<PermissionEntity> getAllPermissions();

    void deactivatePermission(Long id);
}
