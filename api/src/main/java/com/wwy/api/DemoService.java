package com.wwy.api;

import com.wwy.entity.DemoModel;

public interface DemoService {

    String sayHello(String name);

    String modelHello(DemoModel demoModel);

    default void testDefaultMethod(){
        sayHello("aaa");
    }
}
