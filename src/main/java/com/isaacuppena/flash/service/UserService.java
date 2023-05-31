package com.isaacuppena.flash.service;

import com.isaacuppena.flash.model.User;
import com.isaacuppena.flash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}
