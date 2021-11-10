package com.swjd.demo3mp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {
    @TableId//(value= "user_id" type=IdType.AUTO)
    private Long id;//user_id
    //@TableField("user_name")
    private String name;//user_name
    private Integer age;
    private String email;
}
