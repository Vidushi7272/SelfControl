package com.vidushi.selfcontrol.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class TaskRequestDTO {

    @NotBlank(message = "Title cannot be empty")
    @Size(max = 100, message = "Title cannot exceed 100 characters.")
    private String title;

    private String description;

    @Future(message = "Due date can only be set in the future")
    private LocalDateTime dueDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}