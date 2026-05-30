package com.chapter3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.chapter3.beans.Parrot;
import com.chapter3.beans.Person;

@Configuration
@ComponentScan(basePackages = "com.chapter3.beans")
public class ProjectConfig {
    
    //Wiring the beans using a direct method call between the @Bean methods.
    // @Bean
    // public Parrot parrot(){
    //     Parrot p = new Parrot();
    //     p.setName("Koko");
    //     return p;
    // }

    // @Bean
    // public Person person(){
    //     Person p = new Person();
    //     p.setName("Ella");
    //     p.setParrot(parrot());
    //     return p;
    // }

    //Wiring the beans using the @Bean annotated method's parameters.
    // @Bean 
    // public Parrot parrot(){
    //     Parrot p = new Parrot();
    //     p.setName("Koko");
    //     return p;
    // }

    // @Bean
    // public Person person (Parrot parrot){
    //     Person p = new Person();
    //     p.setName("Ella");
    //     p.setParrot(parrot);
    //     return p;
    // }
}
