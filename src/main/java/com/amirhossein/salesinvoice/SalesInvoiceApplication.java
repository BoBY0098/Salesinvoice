package com.amirhossein.salesinvoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource({"file:db.properties"})
@EnableJpaRepositories
public class SalesInvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesInvoiceApplication.class, args);
    }

}
