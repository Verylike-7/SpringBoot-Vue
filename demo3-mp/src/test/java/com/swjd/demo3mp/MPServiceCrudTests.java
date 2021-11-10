package com.swjd.demo3mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swjd.demo3mp.mapper.UserMapper;
import com.swjd.demo3mp.pojo.User;
import com.swjd.demo3mp.service.UserService;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootTest
class MPServiceCrudTests {

    @Autowired
    private UserService  userService;

    /**
     * 查询业务分2类
     *-查一个  getxxxx
     * 查多个  Listxxxxx
     * */
    @Test
    void testget(){
        // 根据ID查询
        User byId = userService.getById(1L);
        System.out.println(byId);
        // 查询（根据ID 批量查询）
        Collection<User> users = userService.listByIds(Arrays.asList(1L, 2L, 3L));
        users.forEach(System.out::println);
        // 查询所有
        List<User> list = userService.list();
        list.forEach(System.out::println);

    }

    @Test
    void testSave(){
//        // 插入一条记录（选择字段，策略插入）
//        User user = new User();
//        user.setId(6L);
//        user.setName("Amy");
//        user.setAge(16);
//        user.setEmail("amy@itcast.cn");
//        userService.save(user);
//        System.out.println(user);
        // 插入（批量）
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user1 = new User();
            user1.setName("Amy"+i);
            user1.setAge(16+i);
            user1.setEmail("amy"+i+"@itcast.cn");
            list.add(user1);
        }
        userService.saveBatch(list);
        System.out.println(list);
    }
    @Test
    void testRemove(){
        // 根据 ID 删除
        userService.removeById(8L);
        // 删除（根据ID 批量删除）
        userService.removeByIds(Arrays.asList(9L,10L,11L,12L,13L,14L));

    }
    @Test
    void testUpdateUser(){
        // 根据 ID 选择修改
//        User user = new User();
//        user.setId(7L);
//        user.setName("张三");
//        user.setAge(18);
//        user.setEmail("zhangsan@itcast.cn");
//        userService.updateById(user);
//        System.out.println(user);

        // 根据ID 批量更新
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user1 = new User();
            user1.setId(5L+i);
            user1.setName("张三"+i);
            user1.setAge(18+i);
            user1.setEmail("zhangsan"+i+"@itcast.cn");
            list.add(user1);
        }
        userService.updateBatchById(list);
        System.out.println(list);
    }

}
