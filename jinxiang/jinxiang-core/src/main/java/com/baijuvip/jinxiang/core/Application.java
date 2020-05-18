package com.baijuvip.jinxiang.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.baijuvip.jinxiang.db", "com.baijuvip.jinxiang.core"})
@MapperScan("com.baijuvip.jinxiang.db.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}