package com.angular.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.angular.demo.entity.User;



public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUser(@Param("username") String username,@Param("password") String password);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}