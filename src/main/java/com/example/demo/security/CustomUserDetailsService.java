package com.example.demo.security;

import com.example.demo.entity.Stuentity;
import com.example.demo.repository.StuRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StuRepository repo;

    public CustomUserDetailsService(StuRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Stuentity user = repo.findByEmail(email)
            .orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("USER")
                .build();
    }
}
