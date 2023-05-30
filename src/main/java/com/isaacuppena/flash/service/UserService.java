package com.isaacuppena.flash.service;

import com.isaacuppena.flash.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User createUser(String userName, String password) {
        User user = new User(userName, password);

        return user;
    }
}
