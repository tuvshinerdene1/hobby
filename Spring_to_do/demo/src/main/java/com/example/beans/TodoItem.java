package com.example.beans;

public class TodoItem {
    private int id;
    private String description;
    private boolean completed;

    public TodoItem(int id, String description){
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public int GetId(){return id;}
    public void setId(int id){this.id = id;}
    public String getDesc(){return description;}
    public void setDesc(String description){this.description = description; }
    public boolean isCompleted(){return completed;}
    public void setCompleted(boolean completed){this.completed = completed;}

    @Override
    public String toString(){
        return "[" + (completed ? "X" : " ") + "] ID: " + id + " - " + description;
    }
}
