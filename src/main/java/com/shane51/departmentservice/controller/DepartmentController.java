package com.shane51.departmentservice.controller;

import com.shane51.departmentservice.client.EmployeeClient;
import com.shane51.departmentservice.model.Department;
import com.shane51.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentRepository repository;
    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping("/")
    public Department add(@RequestBody Department department) {
        return repository.add(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @GetMapping("/")
    public List<Department> findAll() {
        return repository.findAll();
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findByOrganizationId(@PathVariable Long organizationId) {
        return repository.findByOrganization(organizationId);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
        List<Department> departments = repository.findByOrganization(organizationId);
        departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
        return departments;
    }



}
