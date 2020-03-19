package com.wwy.service;

import com.wwy.api.DemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class DemoServiceTest extends BaseServiceTest {

    //    @Reference
    @Autowired
    DemoService demoService;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testSayHello() {
        String aaa = demoService.sayHello("aaa");
        System.out.println(aaa);
    }

    @Test
    public void testRedisTemplate() {
        redisTemplate.opsForValue().set("a", 1);
        System.out.println(111);
    }
}
