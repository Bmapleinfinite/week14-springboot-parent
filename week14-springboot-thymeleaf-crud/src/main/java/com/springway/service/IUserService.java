package com.springway.service;

import java.util.List;

import com.springway.entity.User;

public interface IUserService {

    List<User> getAllUsers();

    void addUser(String username, String password);

    void deleteUser(String id);

    User getUserById(String id);

    void updateUser(String id, String username, String password);
    
}
