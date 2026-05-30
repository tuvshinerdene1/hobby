package com.chapter3.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chapter3.beans.Parrot;
import com.chapter3.beans.Person;
import com.chapter3.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        // var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        // Person person = context.getBean(Person.class);
        // Parrot parrot = context.getBean(Parrot.class);

        // System.out.println("Person's name: "+person.getName());
        // System.out.println("Parrot's name: "+ parrot.getName());
        // System.out.println("Person's parrot: "+ person.getParrot());


        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        Person person = context.getBean(Person.class);

        System.out.println("Person's name: "+person.getName());
        System.out.println("Person's parrot: "+ person.getParrot());

    }
}