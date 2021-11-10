package com.swjd.demo3mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swjd.demo3mp.mapper.UserMapper;
import com.swjd.demo3mp.pojo.User;
import com.swjd.demo3mp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{


}
