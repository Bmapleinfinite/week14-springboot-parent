package com.springway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName week14-springboot-parent
 * @Author Lenovo
 * @Description TODO
 * @Date 2022/10/27 14:23
 * @Version 1.0
 */
@RestController
public class HomeController {

    @GetMapping("/test")
    public String test(){
        return "hello world";
    }
}
