
package com.example.demo.config;

import com.example.demo.servlet.SimpleHelloServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    /**
     * Registers the SimpleHelloServlet at /hello-servlet
     */
    @Bean
    public ServletRegistrationBean<SimpleHelloServlet> simpleHelloServlet() {
        ServletRegistrationBean<SimpleHelloServlet> servletBean =
                new ServletRegistrationBean<>(new SimpleHelloServlet(), "/hello-servlet");
        servletBean.setName("SimpleHelloServlet");
        return servletBean;
    }
}
