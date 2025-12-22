package com.example.demo.service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserAccountRepository userAccountRepository;

    public AuthServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto request) {
        if (userAccountRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        UserEntity user = new UserEntity(request.getEmail(), request.getFullName(), true);
        user.setPassword(request.getPassword());
        userAccountRepository.save(user);

        return new AuthResponseDto("success");
    }

    @Override
    public AuthResponseDto login(AuthRequestDto request) {
        UserEntity user = userAccountRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        return new AuthResponseDto("success");
    }
}