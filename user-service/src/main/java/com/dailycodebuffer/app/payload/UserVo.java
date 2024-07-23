package com.dailycodebuffer.app.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo {

    private Long userId;
    private String userName;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
