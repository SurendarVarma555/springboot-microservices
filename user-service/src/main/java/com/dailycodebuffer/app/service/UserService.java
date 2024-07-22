package com.dailycodebuffer.app.service;

import com.dailycodebuffer.app.entity.User;

public interface UserService {

    public User saveUser (User user);

    public User getUserWithDepartmentById (Long userId);
}
