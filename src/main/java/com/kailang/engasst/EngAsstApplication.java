package com.kailang.engasst;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootConfiguration
@SpringBootApplication
@MapperScan(basePackages = "com.kailang.engasst")
public class EngAsstApplication {

    public static void main(String[] args) {
        SpringApplication.run(EngAsstApplication.class, args);
    }

}
