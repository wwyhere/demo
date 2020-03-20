package com.wwy.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath*:META-INF/spring/*.xml"})
public class AdminApplication {

    public static void main(String[] args) {
//        SpringApplication.run(AdminApplication.class, args);

        new SpringApplicationBuilder(AdminApplication.class)
                .web(WebApplicationType.SERVLET) // NONE为非web工程，一般用于专门提供接口的jar
                .run(args);
    }

}
