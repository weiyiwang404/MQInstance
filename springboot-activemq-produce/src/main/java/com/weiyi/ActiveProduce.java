package com.weiyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @ClassName ActiveProduce
 * @Description:
 * @Author wangwy
 * @Date 2020/7/31 16:22
 * @Version 1.0
 */
@Service
public class ActiveProduce {

    @Autowired
    private JmsMessagingTemplate template;

    @Autowired
    private Queue queue;

    public void sendMessage () {
        template.convertAndSend(queue, "****" + UUID.randomUUID().toString().substring(0, 6));
    }

    /**
     * 定时任务,每3秒执行一次。 主启动类需开启定时注解
     */
    @Scheduled(fixedDelay = 3000)
    public void sendScheduledMessage () {
        // sendMessage();
        System.out.println("发送成功...");
    }
}
