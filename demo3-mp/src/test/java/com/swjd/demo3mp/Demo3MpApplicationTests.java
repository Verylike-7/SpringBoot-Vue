package com.swjd.demo3mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swjd.demo3mp.mapper.UserMapper;
import com.swjd.demo3mp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Demo3MpApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testFindUser() {
        //根据ID查
        User user = userMapper.selectById(1L);
        System.out.println(user);
        //差所有
        //List<User> userList = userMapper.selectList(null);
        List<User> userList1 = userMapper.selectBatchIds(Arrays.asList(1L,2L,3L));//根据ID批量查
        for (User user1 : userList1) {
            System.out.println(user1);
        }
    }
    @Test
    void testQueryByWrapper(){
        //根据wrapper查询
        // 定义wrapper
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //SELECT id,user_name AS name,email,age FROM tb_user WHERE (user_name LIKE ? AND age <= ?) ORDER BY age ASC
        // 模糊
        wrapper.like("user_name", "o")
                // 范围
                .le("age", 30)
                // 排序
                .orderByAsc("age");
                // 查询
        List<User> list = userMapper.selectList(wrapper);

        list.forEach(System.out::println);
    }

    @Test
    void testaddUser(){
        User user = new User();
        //新增时，只新增非null字段
        user.setId(6L);
        user.setName("Amy");
        user.setAge(16);
        user.setEmail("amy@itcast.cn");
        userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    void testUpdateUser(){
        User user = new User();
        //UPDATE tb_user SET user_name=?, age=? WHERE id=?
        //更新时，只更新非null字段
        user.setId(6L);
        user.setName("张三");
        user.setAge(18);
        user.setEmail("zhangsan@itcast.cn");
        userMapper.updateById(user);
        System.out.println(user);
    }

    @Test
    void deleteUser(){
        //根据ID删一个
        userMapper.deleteById(6L);
        //根据ID删多个
        //userMapper.deleteBatchIds(Arrays.asList(1L,2L,3L));
    }

}
