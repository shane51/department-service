package com.shane51.departmentservice;

import com.shane51.departmentservice.model.Department;
import com.shane51.departmentservice.repository.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DepartmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }


    @Bean
    DepartmentRepository repository() {
        DepartmentRepository repository = new DepartmentRepository();
        repository.add(new Department(1L, "sales"));
        repository.add(new Department(1L, "operation"));
        repository.add(new Department(2L, "Development"));
        repository.add(new Department(2L, "Support"));
        repository.add(new Department(3L, "Testing"));
        return repository;
    }

}
