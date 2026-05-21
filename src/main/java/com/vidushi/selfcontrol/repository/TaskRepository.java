package com.vidushi.selfcontrol.repository;
import com.vidushi.selfcontrol.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}
