package com.example.main;

import com.example.config.ProjectConfig;
import com.example.lib.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // Parrot p = context.getBean("Miki",Parrot.class);
        // System.out.println(p.getName());

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p);
        System.out.println(p.getName());

        // String s = context.getBean(String.class);
        // System.out.println(s);

        // Integer n = context.getBean(Integer.class);
        // System.out.println(n);
    }
}
