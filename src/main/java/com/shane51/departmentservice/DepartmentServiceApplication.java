package com.shane51.departmentservice;

import com.shane51.departmentservice.model.Department;
import com.shane51.departmentservice.repository.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class DepartmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shane51.departmentservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Employee API").description("Documentation Employee V1.0").build());
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
