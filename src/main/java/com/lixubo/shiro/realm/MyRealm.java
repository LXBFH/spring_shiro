package com.lixubo.shiro.realm;

/**
 * @Author LIXUBO
 * @Date 2022-10-07 19:48
 * @description
 * @Version 1.0
 */

import com.lixubo.shiro.entity.UserEntity;
import com.lixubo.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自定义Realm
 */
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    //自定义授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //自定义登录验证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取用户身份信息
        String name=  authenticationToken.getPrincipal().toString();
        //2.调用业务层获取数据库中的用户信息
        UserEntity userEntity = userService.getUserInfoByName(name);
        //3.判断数据库中有信息，将数据封装返回
        if (userEntity!=null) {
            AuthenticationInfo info = new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    userEntity.getPhone(),
                    ByteSource.Util.bytes("salt"),
                    authenticationToken.getPrincipal().toString()
            );
            return info;
        }
        return null;
    }
}

