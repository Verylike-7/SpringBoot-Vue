package com.swjd.demo3mp.controller;

import com.swjd.demo3mp.pojo.User;
import com.swjd.demo3mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("all")
    public List<User> findAll(){
        return userService.list();
    }


}




