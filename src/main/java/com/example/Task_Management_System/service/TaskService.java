package com.example.Task_Management_System.service;

import com.example.Task_Management_System.models.Task;
import com.example.Task_Management_System.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public String add(Task task) {
        taskRepository.save(task);
        return "Task added successfully!!";
    }

    public List<Task> get(Long userId, String order, int pageNo,  int pageSize) throws Exception {
        Optional<Task> optionalTask = taskRepository.findById(userId);
        if(optionalTask.isEmpty()){
            throw new Exception("User not found!!");
        }
        List<Task> taskList = taskRepository.findAll();

        // Sort the responseList based on the specified order (asc/desc)
        if (order.equals("asc")) {
            Collections.sort(taskList, );
        } else if (order.equals("desc")) {
            Collections.sort(taskList, Collections.reverseOrder());
        } else {
            throw new TaskNotFoundException("Add proper order (asc/desc)!!!!");
        }

        // Implement pagination by selecting the sublist based on pageNo and pageSize
        int start = (pageNo - 1) * pageSize;
        int end = Math.min(start + pageSize, taskList.size());
        List<Task> list;

        // Check if the start index is beyond the size of the responseList
        if (taskList.size() < start) {
            list = new ArrayList<>();
        } else {
            list = taskList.subList(start, end);
        }

        return list;

    }

    public Task update_task(Long id, Task task) throws Exception {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new Exception("User not found!!");
        }

        Task existingTask = optionalTask.get();
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setStatus(task.getStatus());

        return taskRepository.save(existingTask);
    }


    public String delete_task(Long id) throws Exception {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new Exception("Task not found!!");
        }
        taskRepository.deleteById(id);

        return  "Task deleted successfully!!";
    }
}
