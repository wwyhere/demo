package com.wwy.service;

import com.wwy.api.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(interfaceClass = DemoService.class)
@Component
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
