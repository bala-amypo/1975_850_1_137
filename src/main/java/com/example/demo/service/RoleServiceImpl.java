package com.example.demo.service;

import com.example.demo.entity.RoleEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity createRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public RoleEntity updateRole(Long id, RoleEntity role) {
        RoleEntity existing = getRoleById(id);
        existing.setName(role.getName());
        return roleRepository.save(existing);
    }

    @Override
    public RoleEntity getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + id));
    }

    @Override
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void deactivateRole(Long id) {
        RoleEntity role = getRoleById(id);
        role.setActive(false);
        roleRepository.save(role);
    }
}
