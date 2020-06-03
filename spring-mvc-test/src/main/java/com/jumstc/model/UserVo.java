package com.jumstc.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2020/6/3 13:34
 * @Auther 林杰
 */
@Data
public class UserVo implements Serializable {

    private long id;
    private String email;
    private String mobile;
    private String username;
    private String role;
}
