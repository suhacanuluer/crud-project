package com.example.crudproject;

import com.example.crudproject.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = PersonRepository.class)
@Configuration
public class CrudProjectApplication{

    public static void main(String[] args) {
        SpringApplication.run(CrudProjectApplication.class, args);
    }

}
