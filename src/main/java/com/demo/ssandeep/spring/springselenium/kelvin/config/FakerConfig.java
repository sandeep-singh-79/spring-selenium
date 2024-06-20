package com.demo.ssandeep.spring.springselenium.kelvin.config;

import com.github.javafaker.Faker;
import com.demo.ssandeep.spring.springselenium.kelvin.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }

}
