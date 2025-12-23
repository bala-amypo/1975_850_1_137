package com.example.demo.service;

import com.example.demo.entity.PermissionEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public PermissionEntity createPermission(PermissionEntity permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public PermissionEntity updatePermission(Long id, PermissionEntity permission) {
        PermissionEntity existing = getPermissionById(id);
        existing.setName(permission.getName());
        return permissionRepository.save(existing);
    }

    @Override
    public PermissionEntity getPermissionById(Long id) {
        return permissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found with id " + id));
    }

    @Override
    public List<PermissionEntity> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public void deactivatePermission(Long id) {
        PermissionEntity permission = getPermissionById(id);
        permission.setActive(false);
        permissionRepository.save(permission);
    }
}
