package com.dailycodebuffer.app.service.impl;

import com.dailycodebuffer.app.entity.User;
import com.dailycodebuffer.app.repository.UserRepository;
import com.dailycodebuffer.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser (User user){

        return userRepository.save(user);
    }


    @Override
    public User getUserWithDepartmentById (Long userId){

        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User does not exists"));


        return null;
    }
}
