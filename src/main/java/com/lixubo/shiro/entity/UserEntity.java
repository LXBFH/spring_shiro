package com.lixubo.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息
 * 
 * @author lixubo
 * @email lxb68@139.com
 * @date 2022-10-07 15:16:14
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 身份证号
	 */
	private String idNumber;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 状态 0:禁用，1:正常
	 */
	private Integer status;

}
