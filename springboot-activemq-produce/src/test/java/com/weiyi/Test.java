package com.weiyi;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @ClassName Test
 * @Description:
 * @Author wangwy
 * @Date 2020/7/31 16:23
 * @Version 1.0
 */
@SpringBootTest(classes = ActiveProduceMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class Test {

    @Autowired
    ActiveProduce activeProduce;

    @org.junit.Test
    public void testSend () throws Exception {
        activeProduce.sendMessage();
    }
}
