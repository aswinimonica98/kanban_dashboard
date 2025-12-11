package com.cap.project.service;

import com.cap.project.domain.User;

public interface AuthService {
    User register(User user);
    String login(String email, String password);
}
