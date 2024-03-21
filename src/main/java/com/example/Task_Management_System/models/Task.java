package com.example.Task_Management_System.models;

import com.example.Task_Management_System.Enum.Status;
import jakarta.persistence.Entity;
import jdk.jshell.Snippet;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Task {
    //title, description, due date, and status (e.g., pending, In Progress, completed).

    String title;

    String description;

    Date dueDate;

    Status status;

}
