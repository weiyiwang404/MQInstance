package com.weiyi.copnfig;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 * @ClassName ConfigBean
 * @Description:
 * @Author wangwy
 * @Date 2020/7/31 16:20
 * @Version 1.0
 */
@Configuration
@EnableJms
public class ConfigBean {
    // 注入配置文件中的 myqueue
    @Value("${myqueue}")
    private String myQueue;

    @Bean
    public ActiveMQQueue queue () {
        return new ActiveMQQueue(myQueue);
    }
}
