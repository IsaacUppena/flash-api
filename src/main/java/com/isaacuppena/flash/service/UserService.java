package com.isaacuppena.flash.service;

import com.isaacuppena.flash.model.User;
import com.isaacuppena.flash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User createUser(String userName, String password) {
        User user = new User(userName, password);

        return user;
    }
}
