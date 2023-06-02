package com.isaacuppena.flash.service;

import com.isaacuppena.flash.model.SecurityUser;
import com.isaacuppena.flash.model.User;
import com.isaacuppena.flash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        return userRepository.insert(new User(username, encodedPassword));
    }

    public User getCurrentUser(@AuthenticationPrincipal SecurityUser user) {
        return user.getUser();
    }
}
