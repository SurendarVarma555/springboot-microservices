package com.dailycodebuffer.app.feignConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "http://localhost:8484", value = "department-feign-client", path = "/api/departments")
public interface DepartmentFeign {

    @GetMapping("/{id}")
    feign.Response getDepartmentById (@PathVariable("id") Long departmentId);


}