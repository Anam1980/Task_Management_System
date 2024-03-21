package com.example.Task_Management_System.service;

import com.example.Task_Management_System.models.Admin;
import com.example.Task_Management_System.models.User;
import com.example.Task_Management_System.repository.AdminRepository;
import com.example.Task_Management_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public void login(Admin admin) {
        adminRepository.save(admin);
        return;
    }
}
