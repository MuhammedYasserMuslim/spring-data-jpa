package com.spring.controller;

import com.spring.model.Department;
import com.spring.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/department")
public class DepartmentController {


    DepartmentServices departmentServices;

    @Autowired

    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @GetMapping("/count")
    public Long count() {
        return departmentServices.count();
    }


    @GetMapping("/departments")
    public List<Department> findAll() {
        return departmentServices.findAll();
    }

    @GetMapping("/department")
    public Optional<Department> findById(@RequestParam Long id) {
        return departmentServices.findById(id);
    }

    @PostMapping("/department")
    public Department insert(Department department) {
        departmentServices.insert(department);
        return department;
    }

    @PutMapping("/department")
    public Department update(Department department) {
        departmentServices.update(department);
        return department;
    }

    @DeleteMapping("/department")
    public Optional<Department> deleteById(@RequestParam Long id) {
        departmentServices.deleteById(id);
        return findById(id);

    }
}
