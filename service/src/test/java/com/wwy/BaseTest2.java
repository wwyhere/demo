package com.wwy;

import com.wwy.api.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:spring/spring-sofa-consumer.xml"})
@org.springframework.boot.autoconfigure.SpringBootApplication
public class BaseTest2 {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BaseTest2.class);
        ApplicationContext applicationContext = springApplication.run(args);

        DemoService demoService = (DemoService) applicationContext.getBean("demoReferenceBolt");
        demoService.sayHello("sss");
    }
}
