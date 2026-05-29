package com.example.lib;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name;

    @PostConstruct
    public void init(){
        this.name = "Kiki";
    }

    public Parrot(){

    }

    public Parrot(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
