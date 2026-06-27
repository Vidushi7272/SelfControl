package com.vidushi.selfcontrol.Service;
import com.vidushi.selfcontrol.DTO.TaskRequestDTO;
import com.vidushi.selfcontrol.DTO.TaskResponseDTO;
import com.vidushi.selfcontrol.Exception.TaskNotFoundException;
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
    private Task toEntity(TaskRequestDTO request){

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());

        if(request.getDueDate()==null){
            task.setDueDate(LocalDateTime.now().plusHours(24));
        }
        else{
            task.setDueDate(request.getDueDate());
        }

        task.setCreatedAt(LocalDateTime.now());
        task.setStatus(false);

        return task;
    }
    private TaskResponseDTO toResponseDTO(Task task){

        TaskResponseDTO response = new TaskResponseDTO();

        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setStatus(task.getStatus());
        response.setDueDate(task.getDueDate());

        return response;
    }
    public TaskResponseDTO createTask(TaskRequestDTO request){
        Task savedTask = t.save(toEntity(request));
        return toResponseDTO(savedTask);
    }
    public TaskResponseDTO statusCompleted(Long id){

        Task task = t.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setStatus(true);

        Task savedTask = t.save(task);

        return toResponseDTO(savedTask);
    }
   public List<TaskResponseDTO> getTask(){
        return t.findAll().stream().map(this::toResponseDTO).toList();

   }
   public void deleteTask(Long id){
       t.findById(id)
               .orElseThrow(() -> new TaskNotFoundException(id));

       t.deleteById(id);
   }
   //filters
   public List<TaskResponseDTO> getCompletedTask(){
        return t.findByStatus(true).stream().map(this::toResponseDTO).toList();
   }
    public List<TaskResponseDTO> getPendingTask(){
        return t.findByStatus(false).stream().map(this::toResponseDTO).toList();
    }
    public List<TaskResponseDTO> getOverDueTask(){
        return t.findByDueDateBefore(LocalDateTime.now()).stream().map(this::toResponseDTO).toList();
    }
    public List<TaskResponseDTO> Sort(String sort){
        if(sort.equals("dueDate")){
            return t.findAllByOrderByDueDateAsc().stream().map(this::toResponseDTO).toList();
        }
        else if(sort.equals("createdAt")){
            return t.findAllByOrderByCreatedAtAsc().stream().map(this::toResponseDTO).toList();
        }
        else{
            throw new IllegalArgumentException("Invalid sort type. Allowed values: dueDate, createdAt");
        }
    }
}
