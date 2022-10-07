package com.lixubo.shiro.controller;

import com.lixubo.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 用户信息
 *
 * @author lixubo
 * @email lxb68@139.com
 * @date 2022-10-07 15:16:14
 */
@RestController
@RequestMapping("shiro/user")
public class UserController {
    @Autowired
    private UserService userService;


}
