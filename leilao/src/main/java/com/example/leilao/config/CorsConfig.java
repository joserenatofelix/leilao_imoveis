package com.example.leilao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite que qualquer endpoint aceite requisições
                .allowedOrigins("http://127.0.0.1:5500") // Origem permitida (onde o front-end está rodando)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("*") // Cabeçalhos permitidos
                .allowCredentials(true); // Permite envio de cookies de sessão, se necessário
    }
}
