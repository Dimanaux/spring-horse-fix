package com.example.fixhorse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfiguration {
    private final ServletPresenter servlet;

    @Autowired
    public ServletConfiguration(ServletPresenter servlet) {
        this.servlet = servlet;
    }

    @Bean
    public ServletRegistrationBean exampleServletBean() {
        return new ServletRegistrationBean<>(
                servlet,
                "/hourse/servlet/count"
        );
    }
}
