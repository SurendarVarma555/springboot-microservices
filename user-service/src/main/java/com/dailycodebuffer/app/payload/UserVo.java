package com.dailycodebuffer.app.payload;

import com.dailycodebuffer.app.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {

    private User user;
    private Department department;

}
