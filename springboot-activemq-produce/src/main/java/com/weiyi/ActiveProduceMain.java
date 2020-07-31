package com.weiyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName ActiveMain
 * @Description:
 * @Author wangwy
 * @Date 2020/7/31 16:19
 * @Version 1.0
 */
@SpringBootApplication
@EnableScheduling
public class ActiveProduceMain {
    public static void main (String[] args) {
        SpringApplication.run(ActiveProduceMain.class, args);
    }
}
