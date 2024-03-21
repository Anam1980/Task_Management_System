package com.example.Task_Management_System.controller;

import com.example.Task_Management_System.models.User;
import com.example.Task_Management_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/auth")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        userService.login(user);
        return new ResponseEntity<>("User added successfully!!", HttpStatus.OK);
    }
}