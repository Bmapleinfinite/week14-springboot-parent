package com.springway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springway.entity.User;
import com.springway.service.IUserService;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/showUserList", method = RequestMethod.GET)
    public String showUserString(Model Model) {
        List<User> userList = userService.getAllUsers();
        Model.addAttribute("userList", userList);
        return new String("showUserList");
    }

    @RequestMapping(value = "/toAddUser", method = RequestMethod.GET)
    public String toAddUser() {
        return new String("addUser");
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String requestMethodName(String username, String password) {
        userService.addUser(username, password);
        return new String("redirect:showUserList");
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
        return new String("redirect:showUserList");
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public String toUpdate(@RequestParam String id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return new String("updateUser");
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(@RequestParam String id, @RequestParam String username, @RequestParam String password) {
        userService.updateUser(id, username, password);
        int i = 5 / 0;
        return new String("redirect:showUserList");
    }

}
