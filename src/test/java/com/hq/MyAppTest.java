package com.hq;

import com.hq.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.Map;

/**
 * SpringBoot单元测试;
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyAppTest {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testHelloService(){
        boolean b = ioc.containsBean("helloService02");
        System.out.println(b);
    }

    @Test
    public void contextLoads() {
        // message自己构造
        // rabbitTemplate.send(exchange, routeKey, message);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息!");
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", map);
    }
}
