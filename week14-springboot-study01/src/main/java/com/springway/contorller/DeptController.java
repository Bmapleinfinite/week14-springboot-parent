package com.springway.contorller;

import com.springway.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @RequestMapping("/test01")
    public Object test01(){
        return "你好呀我的世界";
    }

    @RequestMapping("/test02")
    public Object test02(){
        return new User(1, "你好", "你好呀");
    }

}
