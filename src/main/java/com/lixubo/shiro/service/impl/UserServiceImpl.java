package com.lixubo.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lixubo.shiro.entity.UserEntity;
import com.lixubo.shiro.mapper.UserMapper;
import com.lixubo.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserEntity getUserInfoByName(String name) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        UserEntity userEntity = userMapper.selectOne(wrapper);

        return userEntity;
    }
}