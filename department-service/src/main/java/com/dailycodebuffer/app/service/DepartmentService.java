package com.dailycodebuffer.app.service;

import com.dailycodebuffer.app.entity.Department;

public interface DepartmentService {

    public Department saveDepartment (Department department);

    public Department getDepartmentById (Long departmentId);
}
