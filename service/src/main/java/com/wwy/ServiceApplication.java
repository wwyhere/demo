package com.wwy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
//@EnableDubboConfig
//@EnableAutoConfiguration
public class ServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceApplication.class)
                .web(WebApplicationType.SERVLET) // NONE为非web工程，一般用于专门提供接口的jar
                .run(args);
    }

}
