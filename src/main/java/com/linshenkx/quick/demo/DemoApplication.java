package com.linshenkx.quick.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.linshenkx.quick.demo.repository")
@SpringBootApplication
@PropertySources({
        @PropertySource(value="classpath:properties/cache.properties", ignoreResourceNotFound=false)
})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

