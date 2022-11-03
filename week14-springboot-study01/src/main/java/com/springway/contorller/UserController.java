package com.springway.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

//    @Value("${key}")
//    private String key;
//
//    @Value("${user.username}")
//    private String username;
//
//    @Value("${hobbies[0]}")
//    private Object hobbies;
//
//    @RequestMapping("/test1")
//    public Object test1(){
//
//        logger.info("key: {}", key);
//        logger.error("user: {}", username);
//        logger.error("hobbies: {}", hobbies);
//
//        return "Hello World";
//    }
}
