package model;

public class Todo {
    private int id;
    private String task;
    private boolean completed;

    public Todo(int id, String task, boolean completed){
        this.id = id;
        this.task = task;
        this.completed = completed;
    }

    //getters
    public int getId(){return this.id;}
    public String getTask(){return this.task;}
    public boolean isCompleted(){return completed;}

    @Override
    public String toString(){
        return String.format("{\"id\": %d, \"task\": \"%s\", \"completed\": %b}", id, task, completed);
    }
    
}
