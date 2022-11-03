package com.springway.contorller;

import org.net.framework.core.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetworkServiceController {

    @Autowired
    private NetworkService networkService;

    @RequestMapping("/networkServiceTest")
    public Object networkServiceTest(){
        networkService.print();
        return "测试成功...";
    }
}
