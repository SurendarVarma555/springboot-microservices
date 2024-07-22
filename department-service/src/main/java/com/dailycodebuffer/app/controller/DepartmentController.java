package com.dailycodebuffer.app.controller;


import com.dailycodebuffer.app.entity.Department;
import com.dailycodebuffer.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment (@RequestBody Department department){

        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById (@PathVariable("id") Long departmentId){

        return new ResponseEntity<>(departmentService.getDepartmentById(departmentId), HttpStatus.OK);
    }
}
