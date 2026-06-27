package com.vidushi.selfcontrol.Controller;
import com.vidushi.selfcontrol.DTO.TaskRequestDTO;
import com.vidushi.selfcontrol.DTO.TaskResponseDTO;
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
    public TaskResponseDTO createTask(@Valid @RequestBody TaskRequestDTO request){

        return service.createTask(request);
    }
    // to fetch all tasks
    @GetMapping("/tasks")
    public List<TaskResponseDTO> getTask(){
      return service.getTask();
    }
    //to update task completion
    @PutMapping("/tasks/{id}")
    public TaskResponseDTO Status(@PathVariable Long id){
        return service.statusCompleted(id);
    }
    // to delete task
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }
    @GetMapping("/tasks/completed")
    //filters
    public List<TaskResponseDTO> getCompletedTasks(){
        return service.getCompletedTask();
    }
    @GetMapping("/tasks/pending")
    public List<TaskResponseDTO> getPendingTasks(){
        return service.getPendingTask();
    }
    @GetMapping("/tasks/overdue")
    public List<TaskResponseDTO> getOverDueTask(){
        return service.getOverDueTask();
    }
    @GetMapping("/tasks/sort")
    public List<TaskResponseDTO> Sort(@RequestParam String sort){
    return service.Sort(sort);
    }
}
