package com.shane51.departmentservice.repository;

import com.shane51.departmentservice.model.Department;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DepartmentRepository {
    private List<Department> departments = new ArrayList<>();

    public Department add(Department department) {
        department.setId((long) (departments.size() + 1));
        departments.add(department);
        return department;
    }

    public Department findById(Long id){
        Optional<Department> department = departments.stream().filter( p -> p.getId().equals(id)).findFirst();
        return department.orElseGet(null);
    }


    public List<Department> findAll() {
        return departments;
    }

    public List<Department> findByOrganization(Long organizationId) {
        return departments.stream().filter(p -> p.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }

}
