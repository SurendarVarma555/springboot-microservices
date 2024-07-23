package com.dailycodebuffer.app.controller;

import com.dailycodebuffer.app.entity.User;
import com.dailycodebuffer.app.mapper.UserMapper;
import com.dailycodebuffer.app.payload.ResponseDto;
import com.dailycodebuffer.app.payload.UserDto;
import com.dailycodebuffer.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.saveUser(userDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUserWithDepartment(@PathVariable("id") Long userId){
        return new ResponseEntity<>(userService.getUserWithDepartmentById(userId),HttpStatus.OK);
    }




}
