package com.example.springbootdemo.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootdemo.user.entity.Users;

import java.util.List;

/**
 * @author chp13
 * @description 针对表【users】的数据库操作Service
 * @createDate 2024-10-14 20:19:14
 */
public interface UsersService extends IService<Users> {

    /**
     * @description 根据用户信息查询用户列表
     * @param users
     * @return
     */
    List<Users> queryUser(Users users);


    /**
     * @description 根据用户名查询用户列表
     * @param name
     * @return
     */
    List<Users> getUserListByName(String name);
}
