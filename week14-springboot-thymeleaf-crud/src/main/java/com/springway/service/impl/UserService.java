package com.springway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springway.common.Result;
import com.springway.entity.User;
import com.springway.exception.CommonException;
import com.springway.mapper.UserMapper;
import com.springway.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void addUser(String username, String password) {
        if (username == null || username.length() == 0 || password == null || password.length() == 0) {
            throw new CommonException(Result.BAD_PARAMENT.getCode(), Result.BAD_PARAMENT.getMessage());
        }
        userMapper.addUser(username, password);
    }

    @Override
    public void deleteUser(String id) {
        if (id == null || id.length() == 0) {
            throw new CommonException(Result.BAD_PARAMENT.getCode(), Result.BAD_PARAMENT.getMessage());
        }
        userMapper.deleteUser(id);
    }

    @Override
    public User getUserById(String id) {
        if (id == null || id.length() == 0) {
            throw new CommonException(Result.BAD_PARAMENT.getCode(), Result.BAD_PARAMENT.getMessage());
        }
        return userMapper.getUserById(id);
    }

    @Override
    public void updateUser(String id, String username, String password) {
        if (username == null || username.length() == 0 || password == null || password.length() == 0) {
            throw new CommonException(Result.BAD_PARAMENT.getCode(), Result.BAD_PARAMENT.getMessage());
        }
        if (id == null || id.length() == 0) {
            throw new CommonException(Result.BAD_PARAMENT.getCode(), Result.BAD_PARAMENT.getMessage());
        }
        userMapper.updateUser(id, username, password);
    }

}
