package edu.knoldus.com.handsonspringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequestMapping("/web/clients")
@RestController
@Slf4j
public class MockWebClientController {
    
    @Value("${base.url:NOT-FOUND}")
    private String baseUrl;
    
    public MockWebClientController() {
        log.info("Web Client initialized with base url = {} ... ", this.baseUrl);
    }
    
    @GetMapping(path = "/{clientId}")
    @ResponseBody
    public Mono<String> getUserFromWebClient(@PathVariable String clientId) {
        Mono<String> result;
        if (!baseUrl.equalsIgnoreCase("NOT-FOUND")) {
            result = WebClient.builder()
                    .baseUrl(baseUrl)
                    .build()
                    .get()
                    .uri("/v2/{clientId}", clientId)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(String.class);
        } else {
            log.error("Unable to get the base url for the web client, please check your configurations.");
            result = Mono.empty();
        }
        
        return result;
    }
}
