package com.example.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.http.HttpServlet;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> servletRegistrationBean() {

        HttpServlet servlet = new HttpServlet() {
            private static final long serialVersionUID = 1L;
        };

        ServletRegistrationBean<HttpServlet> bean =
                new ServletRegistrationBean<>(servlet, "/simple-servlet");

        bean.setName("SimpleServlet");
        bean.setLoadOnStartup(1);

        return bean;
    }
}
