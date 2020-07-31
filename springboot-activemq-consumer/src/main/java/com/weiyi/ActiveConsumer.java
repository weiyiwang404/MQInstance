package com.weiyi;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @ClassName ActiveConsumer
 * @Description:
 * @Author wangwy
 * @Date 2020/7/31 16:46
 * @Version 1.0
 */
@Service
public class ActiveConsumer {

    @JmsListener(destination = "${myQueue}")
    public void receive (TextMessage textMessage) throws JMSException {
        System.out.println("收到消息：" + textMessage.getText());
    }
}
