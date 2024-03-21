package com.example.Task_Management_System.repository;

import com.example.Task_Management_System.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User getUserById(Long userId);
}
