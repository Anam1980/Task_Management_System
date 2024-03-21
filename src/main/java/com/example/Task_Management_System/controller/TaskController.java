package com.example.Task_Management_System.controller;

import com.example.Task_Management_System.models.Task;
import com.example.Task_Management_System.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TMS/")
public class TaskController {

    @Autowired
    TaskService taskService;

    //- Establish an API endpoint for adding new tasks.
    //- Create an API endpoint to retrieve a list of tasks for a specific user (Admin users can access all tasks).
    //- Implement features to update task details and mark tasks as completed or delete them.

    @PostMapping("/add_task")
    public ResponseEntity add(@RequestBody Task task){
        try{
            String response = taskService.add(task);
            return  new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get_task")
    public ResponseEntity get(@RequestParam Long userId, @RequestParam String order,  @RequestParam("page") int pageNo, @RequestParam("pageSize") int pageSize){
        try{
            List<Task> taskList = taskService.get(userId, order, pageNo, pageSize);
            return new ResponseEntity<>(taskList, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update_task/{id}")
    public ResponseEntity update_task(@PathVariable Long id, @RequestBody Task task) {
        try {
            Task task1 = taskService.update_task(id, task);
            return new ResponseEntity<>(task1, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @DeleteMapping("/delete_task")
        public ResponseEntity delete_task(@RequestParam Long id){
            try{
                String response = taskService.delete_task(id);
                return  new ResponseEntity<>(response, HttpStatus.CREATED);
            }
            catch (Exception e){
                return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


