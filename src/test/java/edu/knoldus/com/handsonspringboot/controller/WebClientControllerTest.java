/*
package edu.knoldus.com.handsonspringboot.controller;


import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.http.client.reactive.ClientHttpResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class WebClientControllerTest {
    
    private MockWebServer mockWebServer;
    
    private WebClient webClient;
    
    private void startServer(ClientHttpConnector connector) {
        this.mockWebServer = new MockWebServer();
        this.webClient = WebClient.builder()
                .clientConnector(connector)
                .baseUrl(this.mockWebServer.url("/").toString())
                .build();
    }
    
    @AfterEach
    void shutDown() throws IOException {
        this.mockWebServer.shutdown();
    }
    
    @Test
    public void testTheWebClientFunctionality() {
        ClientHttpConnector connector = new ClientHttpConnector() {
            @Override
            public Mono<ClientHttpResponse> connect(HttpMethod method, URI uri, Function<? super ClientHttpRequest, Mono<Void>> requestCallback) {
                return null;
            }
        };
        
        startServer(connector);
        
        prepareResponse(response -> response
                .setHeader("Content-Type", "text/plain")
                .setBody("Hello Spring!"));
        
        Mono<String> result = this.webClient.get()
                .uri("/greeting?name=Spring")
                .retrieve()
                .bodyToMono(String.class);
        
        StepVerifier.create(result)
                .consumeNextWith(res -> {
                    assertEquals(13L, res.length());
                })
                .expectComplete().verify(Duration.ofSeconds(3));
        
    }
    
    private void prepareResponse(Consumer<MockResponse> consumer) {
        MockResponse response = new MockResponse();
        consumer.accept(response);
        this.mockWebServer.enqueue(response);
    }
}
*/
