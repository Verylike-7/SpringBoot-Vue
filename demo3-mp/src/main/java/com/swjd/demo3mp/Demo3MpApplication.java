package com.swjd.demo3mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.swjd.demo3mp.mapper")
public class Demo3MpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo3MpApplication.class, args);
    }

}
