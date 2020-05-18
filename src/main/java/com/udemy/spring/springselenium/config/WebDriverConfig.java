package com.udemy.spring.springselenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class WebDriverConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        return new ChromeDriver();
    }

    @Bean
    public WebDriverWait webdriverWait(WebDriver driver){
        return new WebDriverWait(driver, this.timeout);
    }

}