package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.beans.TodoConsoleApp;
import com.example.config.ProjectConfig;


public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        TodoConsoleApp app = context.getBean(TodoConsoleApp.class);
        app.start();
    }
}