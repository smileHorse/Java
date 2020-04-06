package com.mt.security2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mt.security2.mapper")
public class Security2Application {

    public static void main(String[] args) {
        SpringApplication.run(Security2Application.class, args);
    }

}
