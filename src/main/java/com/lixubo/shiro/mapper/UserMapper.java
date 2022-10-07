package com.lixubo.shiro.mapper;

import com.lixubo.shiro.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息
 * 
 * @author lixubo
 * @email lxb68@139.com
 * @date 2022-10-07 15:16:14
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
	
}
