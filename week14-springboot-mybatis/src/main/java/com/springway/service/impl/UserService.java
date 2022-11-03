package com.springway.service.impl;

import com.springway.entity.User;
import com.springway.mapper.UserMapper;
import com.springway.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
