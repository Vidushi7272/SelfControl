package com.vidushi.selfcontrol;
import jakarta.persistence.*;
import java.time.LocalDateTime;

import jakarta.validation.constraints.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @PositiveOrZero(message="Some error occured due to which position field went to negative")
    private Integer position;
    @NotBlank(message="Title can not be empty")
    @Size(max=100, message="Title cannot exceed 100 characters.")
    private String title;
    private String description;
    private boolean status;
    private LocalDateTime createdAt;
    @Future(message="Due date can only be set in future")
    private LocalDateTime dueDate;

    public Long getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

}
