package com.dailycodebuffer.app.service;

import com.dailycodebuffer.app.entity.Department;
import com.dailycodebuffer.app.repository.DepartmentRepository;
import com.dailycodebuffer.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department saveDepartment (Department department){
        Department savedDepartment = repository.save(department);
        return savedDepartment;
    }

    @Override
    public Department getDepartmentById (Long departmentId){
        Department foundDepartment = repository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department Does Not Exists"));

        return foundDepartment;
    }
}
