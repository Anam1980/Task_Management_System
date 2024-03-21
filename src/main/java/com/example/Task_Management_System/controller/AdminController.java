package com.example.Task_Management_System.controller;

import com.example.Task_Management_System.models.Admin;
import com.example.Task_Management_System.models.User;
import com.example.Task_Management_System.service.AdminService;
import com.example.Task_Management_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/auth")
public class AdminController {

    @Autowired
    AdminService adminService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Admin admin) {
       adminService.login(admin);
        return new ResponseEntity<>("Admin added successfully!!", HttpStatus.OK);
    }
}