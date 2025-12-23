package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Authentication CRUD endpoints")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ---------------- POST ----------------
    @PostMapping("/register")
    @Operation(summary = "Register user", description = "Register a new user")
    public ResponseEntity<AuthResponseDto> register(
            @org.springframework.web.bind.annotation.RequestBody RegisterRequestDto request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    @Operation(summary = "Login user", description = "Login with email and password")
    public ResponseEntity<AuthResponseDto> login(
            @org.springframework.web.bind.annotation.RequestBody AuthRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

    // ---------------- GET ----------------
    @GetMapping("/user/{id}")
    @Operation(summary = "Get user by ID", description = "Fetch user details by user ID")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(authService.getUserById(id));
    }

    // ---------------- PUT ----------------
    @PutMapping("/user/{id}")
    @Operation(summary = "Update user", description = "Update user details")
    public ResponseEntity<?> updateUser(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody RegisterRequestDto request) {
        return ResponseEntity.ok(authService.updateUser(id, request));
    }

    // ---------------- DELETE ----------------
    @DeleteMapping("/user/{id}")
    @Operation(summary = "Delete user", description = "Delete user by ID")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        authService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
