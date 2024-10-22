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


    List<Users> queryUser(Users users );
}
