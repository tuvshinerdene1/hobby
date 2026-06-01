package com.example.beans;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TodoRepository {
    private final List<TodoItem> todoList = new ArrayList<>();
    private int idCounter = 1;

    public void save(String desc){
        TodoItem newItem = new TodoItem(idCounter++, desc);
        todoList.add(newItem);
    }

    public List<TodoItem> findAll(){
        return todoList;
    }

    public boolean completeItem(int id){
        for (TodoItem item: todoList){
            if (item.GetId() == id){
                item.setCompleted(true);
                return true;
            }
        }
        return false;
    }
}
