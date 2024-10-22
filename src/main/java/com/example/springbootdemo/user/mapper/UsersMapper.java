package com.example.springbootdemo.user.mapper;

import com.example.springbootdemo.user.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chp13
 * @since 2024-10-14
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}