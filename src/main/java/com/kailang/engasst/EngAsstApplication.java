package com.kailang.engasst;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.kailang.engasst.dao")
public class EngAsstApplication {

    public static void main(String[] args) {
        SpringApplication.run(EngAsstApplication.class, args);
    }

}
