package com.vidushi.selfcontrol.repository;
import com.vidushi.selfcontrol.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    public List<Task> findByStatus(boolean status);
    public List<Task> findBydueDateBefore(LocalDateTime current);
}
