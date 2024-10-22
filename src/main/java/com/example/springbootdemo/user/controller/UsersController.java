package com.example.springbootdemo.user.controller;

import com.example.springbootdemo.demos.util.R;
import com.example.springbootdemo.user.entity.Users;
import com.example.springbootdemo.user.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chp13
 * @since 2024-10-14
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/get")
    public R<List<Users>> getUsers(@RequestBody Users u) {
        List<Users> users = usersService.queryUser(u);
        log.info("查询用户信息成功！");
        return R.ok(users);
    }

}
