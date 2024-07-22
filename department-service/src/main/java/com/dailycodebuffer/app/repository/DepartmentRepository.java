package com.dailycodebuffer.app.repository;

import com.dailycodebuffer.app.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
