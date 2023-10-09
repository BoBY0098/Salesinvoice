package com.amirhossein.salesinvoice.configuration;


import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SpringFoxConfiguration {

    @Bean
    public Docket apiDocket(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.amirhossein.salesinvoice"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());


        //.additionalModels(typeResolver.resolve());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Sales Invoice",
                "by : Amirhossein Javid",
                "1",
                "",
                new Contact("Amirhossein Javid", "google.com", "amirhoseinjavid@aol.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList()
        );
    }
}
