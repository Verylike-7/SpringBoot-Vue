package com.swjd.demo3mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swjd.demo3mp.pojo.User;
/**
 * MabatisPlus帮我们生成sql语句，必须知道表名称，主键名称，每个字段的 名称
 * 默认实体类名就是表名，属性名是字段名
 * */
public interface UserMapper extends BaseMapper<User> {

}
