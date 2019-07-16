package com.wwy.service;

import com.wwy.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;

public class DemoServiceTest extends BaseServiceTest {

    @Reference
    DemoService demoService;

    @Test
    public void testSayHello() {
        String aaa = demoService.sayHello("aaa");
        System.out.println(aaa);
    }
}
