package com.wwy;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableDubboConfig
public class ServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceApplication.class)
                .web(WebApplicationType.NONE) // NONE为非web工程，一般用于专门提供接口的jar
                .run(args);
    }

}
