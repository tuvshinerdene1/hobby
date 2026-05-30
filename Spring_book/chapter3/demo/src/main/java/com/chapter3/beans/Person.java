package com.chapter3.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Ella";
    private final Parrot parrot;

    @Autowired
    public Person(Parrot parrot){
        this.parrot = parrot;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    // public void setParrot(Parrot parrot){
    //     this.parrot = parrot;
    // }

    public Parrot getParrot(){
        return this.parrot;
    }



}
