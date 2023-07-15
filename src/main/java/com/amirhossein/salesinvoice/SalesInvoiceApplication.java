package com.amirhossein.salesinvoice;

import com.amirhossein.salesinvoice.configuration.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@PropertySource({"file:db.properties"})
@EnableJpaRepositories
public class SalesInvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesInvoiceApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebConfiguration();
    }

}
