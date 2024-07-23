package com.dailycodebuffer.app.service;

import com.dailycodebuffer.app.entity.User;
import com.dailycodebuffer.app.payload.ResponseDto;
import com.dailycodebuffer.app.payload.UserDto;

public interface UserService {

    public UserDto saveUser (UserDto userDto);

    public ResponseDto getUserWithDepartmentById (Long userId);
}
