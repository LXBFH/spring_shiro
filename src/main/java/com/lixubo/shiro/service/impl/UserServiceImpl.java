package com.lixubo.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lixubo.shiro.entity.UserEntity;
import com.lixubo.shiro.mapper.UserMapper;
import com.lixubo.shiro.service.UserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {



}