package com.example.springsecuringweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewControllers("/home").setViewName("home");
        registry.addViewControllers("/").setViewName("home");
        registry.addViewControllers("/hello").setViewName("hello");
        registry.addViewControllers("/login").setViewName("login");
        
    }
} 