package com.zs.gmallusermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.zs.gmallusermanager.mapper")
public class GmallusermanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallusermanagerApplication.class, args);
    }

}
