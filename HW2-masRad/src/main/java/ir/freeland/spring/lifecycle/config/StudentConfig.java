package ir.freeland.spring.lifecycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import ir.freeland.spring.lifecycle.beans.Student;


@Configuration
class StudentConfig {

    @Bean
    Student student() {
        Student student = new Student();
        student.getName();
        return student;
    }

   
    public String getName() {
        return getName();
    }

}
