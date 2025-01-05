package com.example.springbootdemo.user.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.user.entity.Users;
import com.example.springbootdemo.user.mapper.UsersMapper;
import com.example.springbootdemo.user.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chp13
 * @description 针对表【users】的数据库操作Service实现
 * @createDate 2024-10-14 20:19:14
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
        implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public List<Users>  queryUser(Users users ) {

        System.out.println("queryUser方法执行了");

        this.save(users);

        List<Users> user = this.list(Wrappers.<Users>lambdaQuery());

        System.out.println("queryUser方法执行完成");

        return user;
    }

    @Override
    public List<Users> getUserListByName(String name) {

        System.out.println("getUserListByName方法执行了");

        List<Users> userList =  usersMapper.getUserListByName(name);

        System.out.println("getUserListByName方法执行完成");

        return userList;
    }

}




