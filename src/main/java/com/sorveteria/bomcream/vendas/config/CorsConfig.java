package com.sorveteria.bomcream.vendas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private String[] allowedMethods = {"GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"};
    private String[] allowedHeaders = {"Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With"};
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods(allowedMethods).allowedHeaders(allowedHeaders);
    }
}
