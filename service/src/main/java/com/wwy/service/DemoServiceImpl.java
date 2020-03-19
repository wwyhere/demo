package com.wwy.service;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.wwy.api.DemoService;
import com.wwy.entity.DemoModel;

//@SofaService(uniqueId = "demoServiceImpl")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println("Hello " + name);
        return "Hello " + name;
    }

    @Override
    public String modelHello(DemoModel demoModel) {
        System.out.println(demoModel.getName() + ":" + demoModel.getAge());
        return "Hello " + demoModel.getName() + ":" + demoModel.getAge();
    }
}
