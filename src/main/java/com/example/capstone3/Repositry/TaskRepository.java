package com.example.capstone3.Repositry;

import com.example.capstone3.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findTaskById(Integer id);
}
