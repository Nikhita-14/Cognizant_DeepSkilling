package com.example.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing // Required to enable entity tracking fields (Exercise 7)
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        // Mock system mock operator identity string for auditing collection
        return () -> Optional.of("System_Admin_User");
    }
}