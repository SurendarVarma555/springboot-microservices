package com.dailycodebuffer.app.service.impl;

import com.dailycodebuffer.app.entity.User;
import com.dailycodebuffer.app.feignConfig.DepartmentFeign;
import com.dailycodebuffer.app.payload.Department;
import com.dailycodebuffer.app.payload.UserVo;
import com.dailycodebuffer.app.repository.UserRepository;
import com.dailycodebuffer.app.service.UserService;
import com.google.gson.Gson;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentFeign departmentFeign;

    @Override
    public User saveUser (User user){

        return userRepository.save(user);
    }


    @Override
    public UserVo getUserWithDepartmentById (Long userId){

        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User does not exists"));
        Response response = departmentFeign.getDepartmentById(foundUser.getDepartmentId());
        Department department = null;
        try (Reader reader = new InputStreamReader(response.body().asInputStream())) {
            Gson gson = new Gson();
            department = gson.fromJson(reader, Department.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        UserVo vo = new UserVo();

        vo.setUserId(foundUser.getUserId());
        vo.setUserName(foundUser.getUserName());

        vo.setDepartmentName(department.getDepartmentName());
        vo.setDepartmentCode(department.getDepartmentCode());
        vo.setDepartmentAddress(department.getDepartmentAddress());
        return vo;
    }
}
