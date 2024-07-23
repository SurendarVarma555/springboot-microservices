package com.dailycodebuffer.app.service.impl;

import com.dailycodebuffer.app.entity.User;
import com.dailycodebuffer.app.mapper.UserMapper;
import com.dailycodebuffer.app.payload.DepartmentDto;
import com.dailycodebuffer.app.payload.ResponseDto;
import com.dailycodebuffer.app.payload.UserDto;
import com.dailycodebuffer.app.repository.UserRepository;
import com.dailycodebuffer.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public UserDto saveUser (UserDto userDto){
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public ResponseDto getUserWithDepartmentById (Long userId){

        ResponseDto responseDto = new ResponseDto();

        User user = userRepository.findById(userId).get();
        UserDto userDto = UserMapper.mapToUserDto(user);

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + user.getDepartmentId(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();
        System.out.println(responseEntity.getStatusCode());

        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }
}
