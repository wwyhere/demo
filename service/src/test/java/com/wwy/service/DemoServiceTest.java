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
        long l = System.currentTimeMillis();
        redisTemplate.opsForValue().set("a", 1);
        long l2 = System.currentTimeMillis();
        System.out.println("写入耗时:"+(l2-l));
        Object a = redisTemplate.opsForValue().get("a");
        long l3 = System.currentTimeMillis();
        System.out.println("读取耗时:"+(l3-l2));
    }
}
