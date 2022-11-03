package com.springway.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.springway.entity.User;

@Repository
public interface UserMapper {

    /**
     * 查询所有用户信息
     * 
     * @return
     */
    List<User> getAllUsers();

    /**
     * 添加用户信息
     * 
     * @param username
     * @param password
     * @return
     */
    Integer addUser(@Param("username") String username, @Param("password") String password);

    /**
     * 根据ID删除用户
     * 
     * @param id
     * @return
     */
    Integer deleteUser(String id);

    /**
     * 根据ID获取用户信息
     * 
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     * 根据ID修改用户信息
     * 
     * @param id
     * @param username
     * @param password
     * @return
     */
    Integer updateUser(@Param("id") String id,
            @Param("username") String username,
            @Param("password") String password);

}
