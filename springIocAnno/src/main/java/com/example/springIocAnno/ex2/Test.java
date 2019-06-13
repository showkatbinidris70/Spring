package com.example.springIocAnno.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
        Student std = ctx.getBean(Student.class);
        std.setName("Showkat");
        System.out.println(std);
    }
}
