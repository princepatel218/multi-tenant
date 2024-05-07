package com.learn.multitenant.security;

import com.learn.multitenant.domain.User;

public interface JwtService {

    String generateToken(User user);

    String extractUserEmail(String token);

    boolean validateToken(String token);
}