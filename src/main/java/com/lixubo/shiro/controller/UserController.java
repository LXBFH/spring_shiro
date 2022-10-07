package com.lixubo.shiro.controller;

import com.lixubo.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户信息
 *
 * @author lixubo
 * @email lxb68@139.com
 * @date 2022-10-07 15:16:14
 */
@RestController
@RequestMapping("myController")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userLogin")
    @ResponseBody
    public String userLogin(String name,String phone){

        //1.获取subject 对象
        Subject subject = SecurityUtils.getSubject();
        //2.封装请求到token
        AuthenticationToken token = new UsernamePasswordToken(name, phone);
        System.out.println("token"+token);
        //3.调用login方法进行验证
        try {
            subject.login(token);
            System.out.println("登录成功");
            return "登录成功";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败");
            return "登录失败";
        }
    }

}
