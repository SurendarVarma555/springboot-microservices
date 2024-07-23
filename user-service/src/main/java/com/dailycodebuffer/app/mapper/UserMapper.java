package com.dailycodebuffer.app.mapper;

import com.dailycodebuffer.app.entity.User;
import com.dailycodebuffer.app.payload.UserDto;
/*
 *
 *  1. Converting AccountDto to Account
 *  2. Converting Account to AccountDto
 *
 * */

public class UserMapper {

    public static User mapToUser (UserDto userDto){
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setDepartmentId(userDto.getDepartmentId());
        return user;
    }

    public static UserDto mapToUserDto (User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setDepartmentId(user.getDepartmentId());
        return userDto;

    }
}
