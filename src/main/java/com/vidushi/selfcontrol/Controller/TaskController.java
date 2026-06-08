package com.vidushi.selfcontrol.Controller;
import com.vidushi.selfcontrol.Service.TaskService;
import com.vidushi.selfcontrol.Task;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service){
        this.service=service;
    }
    //to create new task
    @PostMapping("/tasks")
    public Task createTask(@Valid @RequestBody Task task){
        return service.createTask(task);
    }
    // to fetch all tasks
    @GetMapping("/tasks")
    public List<Task> getTask(){
      return service.getTask();
    }
    //to update task completion
    @PutMapping("/tasks/{id}")
    public Task Status(@PathVariable Long id){
        return service.statusCompleted(id);
    }
    // to delete task
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }
    @GetMapping("/tasks/completed")
    //filters
    public List<Task> getCompletedTasks(){
        return service.getCompletedTask();
    }
    @GetMapping("/tasks/pending")
    public List<Task> getPendingTasks(){
        return service.getPendingTask();
    }
    @GetMapping("/tasks/overdue")
    public List<Task> getOverDueTask(){
        return service.getOverDueTask();
    }
}
