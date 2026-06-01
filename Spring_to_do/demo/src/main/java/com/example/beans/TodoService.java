package com.example.beans;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TodoService {
    @Autowired
    private TodoRepository repository ;

    public void addTodo(String description){
        if (description == null || description.trim().isEmpty()){
            System.out.println("Error task description cannot be empty");
            return;
        }
        repository.save(description);
        System.out.println("Task added successfully");
    }

    public List<TodoItem> getAllTodos(){
        return repository.findAll();
    }

    public void markAsCompleted(int id) {
        boolean success = repository.completeItem(id);
        if (success) {
            System.out.println("Task #" + id + " marked as completed!");
        } else {
            System.out.println("Error: Task with ID " + id + " not found.");
        }
    }
}
