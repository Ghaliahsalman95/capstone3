package com.example.capstone3.Service;


import com.example.capstone3.API.APIException;
import com.example.capstone3.Model.Task;
//import com.example.capstone3.Repository.TaskRepository;
import com.example.capstone3.Repositry.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Integer id, Task task) {
        Task t = taskRepository.findTaskById(id);
        if (t == null) {
            throw new APIException("task not found!");
        }
        t.setStatus(task.getStatus());
        t.setCost(task.getCost());
        t.setLawyer_id(task.getLawyer_id());
        t.setDescription(task.getDescription());

        taskRepository.save(t);
    }

    public void deleteTask(Integer id) {
        Task task = taskRepository.findTaskById(id);
        if (task == null) {
            throw new APIException("task not found!");
        }
        taskRepository.delete(task);
    }
}
