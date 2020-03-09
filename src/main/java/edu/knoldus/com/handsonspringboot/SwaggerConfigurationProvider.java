package edu.knoldus.com.handsonspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfigurationProvider {
    
    private static final String TITLE = "Educational Content";
    private static final String DESCRIPTION = "This blog provides insight on how to integrate swagger docs to your spring web flux services.";
    private static final String VERSION = "V1.0";
    private static final String TERMS_OF_SERVICE_URL = "N/A";
    private static final Contact CONTACT = new Contact("Prashant_Sharma", "https://blog.knoldus.com/?s=prashant",
            "prashant.sharma@knoldus.com");
    private static final String LICENSE = "Apache 2.0";
    private static final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0";
    private static final Set<String> PRODUCES = new HashSet<>(Arrays.asList("application/json", "application/text"));
    private static final Set<String> CONSUMES = new HashSet<>(Arrays.asList("application/json", "application/text"));
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo(TITLE, DESCRIPTION, VERSION, TERMS_OF_SERVICE_URL, CONTACT, LICENSE,
                        LICENSE_URL, new ArrayList<>()))
                .host("localhost:9000/edu")
                .produces(PRODUCES)
                .consumes(CONSUMES);
    }
}
