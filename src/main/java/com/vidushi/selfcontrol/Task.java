package com.vidushi.selfcontrol;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Integer position;
    private String title,description;
    private boolean status;
    private LocalDateTime createdAt,dueDate;
}
