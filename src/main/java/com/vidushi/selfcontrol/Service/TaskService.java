package com.vidushi.selfcontrol.Service;
import com.vidushi.selfcontrol.Task;
import com.vidushi.selfcontrol.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository t;
    public TaskService(TaskRepository x){
        t=x;
    }
   public Task createTask(Task task){
        task.setCreatedAt(LocalDateTime.now());
        if(task.getDueDate()==null){
            task.setDueDate(LocalDateTime.now().plusHours(24));
        }
        return t.save(task);
   }
   public List<Task> getTask(){
        return t.findAll();
   }
   public Task statusCompleted(Long id){
        Task task= t.findById(id).orElseThrow();
        task.setStatus(true);
        return t.save(task);
   }
   public void deleteTask(Long id){
        t.deleteById(id);
   }
   public List<Task> getCompletedTask(){
   return t.findByStatus(true);
   }
    public List<Task> getPendingTask(){
        return t.findByStatus(false);
    }
}
