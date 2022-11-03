package com.springway.controller;

import com.springway.entity.User;
import com.springway.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName week14-springboot-parent
 * @Author Lenovo
 * @Description TODO
 * @Date 2022/10/25 9:51
 * @Version 1.0
 */
@RestController
@Api(tags = "用户模块")
public class UserController {

    @GetMapping("/findUserById")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer", paramType = "query")
    @ApiOperation(value = "通过ID寻找用户", notes = "id不能为空")
    public Result findUserById(@RequestParam(value = "id", required = true) Integer id){
        return Result.genOkResult().setData("user", new User(1,"miku","123"));
    }

    @GetMapping("/findUserById_path/{id}")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer", paramType = "path")
    @ApiOperation(value = "通过ID寻找用户_Path", notes = "id不能为空")
    public Result findUserById_path(@PathVariable("id") Integer id){
        return Result.genOkResult().setData("user", new User(1,"miku","123"));
    }
}
