package com.lixubo.shiro.config;

import com.lixubo.shiro.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LIXUBO
 * @Date 2022-10-07 20:02
 * @description
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private MyRealm myRealm;


    //配置 securityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        //1.创建 DefaultWebSecurityManager 对象
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //2.创建加密对象，设置相关属性
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //2.1采用 MD5 加密
        matcher.setHashAlgorithmName("md5");
        //2.2迭代加密次数
        matcher.setHashIterations(3);
        //3.将加密对象存入myRealm中
        myRealm.setCredentialsMatcher(matcher);
        //4.将myRealm 存入 DefaultWebSecurityManager 对象
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    //配置shiro 内置拦截器范围
    @Bean
    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        // 设置不认证可以访问的资源
        defaultShiroFilterChainDefinition.addPathDefinition("/myController/userLogin","anon");
        defaultShiroFilterChainDefinition.addPathDefinition("/login","anon");

        //设置需要登录认证拦截的资源
        defaultShiroFilterChainDefinition.addPathDefinition("/**","authc");
        return defaultShiroFilterChainDefinition;
    }






    //创建自定义Realm

}

