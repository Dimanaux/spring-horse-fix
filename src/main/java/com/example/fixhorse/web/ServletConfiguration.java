package com.example.fixhorse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfiguration {
    @Autowired
    private ServletPresenter servlet;

    @Bean
    public ServletRegistrationBean exampleServletBean() {
        ServletRegistrationBean<ServletPresenter> registration = new ServletRegistrationBean<>(
                servlet,
                "/hourse/servlet/count"
        );
        return registration;
    }
}
