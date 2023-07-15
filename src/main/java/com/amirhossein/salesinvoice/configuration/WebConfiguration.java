package com.amirhossein.salesinvoice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author Amin Ne'mati
 * Project: mom_life
 * @version 0.0.1
 * @since ۲۰۲۲/05/07  10:55
 */

@Configuration
public class WebConfiguration implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE");

        WebMvcConfigurer.super.addCorsMappings(registry);
    }


}