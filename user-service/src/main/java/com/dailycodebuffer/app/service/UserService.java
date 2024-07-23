package com.dailycodebuffer.app.service;

import com.dailycodebuffer.app.entity.User;
import com.dailycodebuffer.app.payload.UserVo;

public interface UserService {

    public User saveUser (User user);

    public UserVo getUserWithDepartmentById (Long userId);
}
