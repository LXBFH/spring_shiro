package com.lixubo.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Author LIXUBO
 * @Date 2022-10-07 21:06
 * @description
 * @Version 1.0
 */
public class ShiroMD5 {
    public static void main(String[] args) {
        //密码明文
        String phone = "13119385125";
//        使用MD5加密
        Md5Hash md5Hash = new Md5Hash(phone);
        System.out.println("md5加密："+md5Hash.toHex());
        // 带盐的 MD5 加密
        Md5Hash salt = new Md5Hash(phone, "salt");
        System.out.println("带盐的MD5 加密："+salt.toHex());
        // 多次迭代加密
        Md5Hash salt3 = new Md5Hash(phone, "salt", 3);
        System.out.println("md5带盐 3次加密"+salt3.toHex());

    }
}
