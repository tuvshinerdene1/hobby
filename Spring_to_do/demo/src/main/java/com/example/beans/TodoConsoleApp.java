package com.example.beans;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoConsoleApp {
    @Autowired
    private TodoService service;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== SPRING TO-DO APP ===");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.println("\n--- Your Tasks ---");
                    var tasks = service.getAllTodos();
                    if (tasks.isEmpty()) System.out.println("No tasks found!");
                    else tasks.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    service.addTodo(desc);
                    break;
                case 3:
                    System.out.print("Enter task ID to complete: ");
                    int id = scanner.nextInt();
                    service.markAsCompleted(id);
                    break;
                case 4:
                    System.out.println("Exiting App. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
