package com.example.Task_Management_System.service;

import com.example.Task_Management_System.models.User;
import com.example.Task_Management_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void login(User user) {
        userRepository.save(user);
        return;
    }
}

