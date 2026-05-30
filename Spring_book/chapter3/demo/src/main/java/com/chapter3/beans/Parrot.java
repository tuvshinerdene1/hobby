package com.chapter3.beans;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Koko";

    public Parrot(){
        System.out.println("Parrot created");
    }

    public Parrot(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Parrot : " + name;
    }
    
}
