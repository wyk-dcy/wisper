package com.wyk.wisper.config;

import com.wyk.wisper.pojo.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {

    @Bean
    public A a() {
        return new A();
    }
}
