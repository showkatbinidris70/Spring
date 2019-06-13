package com.example.springIocAnno.ex2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public  Student studentbean(){

        return new Student();
    }

}
