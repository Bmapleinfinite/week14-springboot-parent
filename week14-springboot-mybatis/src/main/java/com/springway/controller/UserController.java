package com.springway.controller;

import com.springway.entity.User;
import com.springway.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAllUser")
    public Object findAllUser(){
        Logger logger = LoggerFactory.getLogger(UserController.class);
        logger.error("这是一条错误信息");
        return (List<User>) userService.findAllUser();
    }
}
