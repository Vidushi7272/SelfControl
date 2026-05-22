package com.vidushi.selfcontrol.Controller;
import com.vidushi.selfcontrol.Service.TaskService;
import com.vidushi.selfcontrol.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service){
        this.service=service;
    }
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task){
        return service.createTask(task);
    }
    @GetMapping("/tasks")
    public List<Task> getTask(){
      return service.getTask();
    }
}
