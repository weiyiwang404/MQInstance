package com.weiyi.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * description:
 *
 * @author weiyi
 * @date 2020/7/28 21:41
 */
public class JmsConsumer_Topic {

    public static final String ACTIVEMQ_URL = "tcp://192.168.31.92:61616";
    public static final String TOPIC_NAME = "topic_one";

    public static void main(String[] args) throws JMSException, Exception {
        System.out.println("*****消费者2*****");
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        // 5 创建消息的消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);

        messageConsumer.setMessageListener((message) -> {
            if (null != message && message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("listener消费者的消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
