package com.dailycodebuffer.app.controller;

import com.dailycodebuffer.app.entity.User;
import com.dailycodebuffer.app.payload.UserVo;
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
    public ResponseEntity<User> saveUser (@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserVo> getUserWithDepartmentById (@PathVariable("id") Long userId){

        return new ResponseEntity<>(userService.getUserWithDepartmentById(userId), HttpStatus.OK);

    }
}
