package com.example.back_monolito.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("https://grupo-c-clinica.github.io/**"); // Especifica el origen permitido
        corsConfiguration.addAllowedHeader("*"); // Permite todos los headers
        corsConfiguration.addAllowedMethod("*"); // Permite todos los métodos HTTP
        corsConfiguration.setAllowCredentials(true); // Permite el uso de credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // Aplica la configuración a todas las rutas

        return new CorsFilter(source);
    }
}
