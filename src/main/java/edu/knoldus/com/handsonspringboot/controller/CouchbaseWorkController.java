package edu.knoldus.com.handsonspringboot.controller;

import edu.knoldus.com.handsonspringboot.repository.couchbase.CouchbaseRepository;
import edu.knoldus.com.handsonspringboot.repository.couchbase.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/edu/db")
public class CouchbaseWorkController {
    
    @Autowired
    private CouchbaseRepository repository;
    
    @GetMapping(value = "/users/{userId}"/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public Mono<ResponseEntity<User>> getUserName(@PathVariable String userId) {
        return repository.findById(userId)
                .switchIfEmpty(Mono.fromCallable(() -> {
                    throw new RuntimeException("User Id " + userId + " Not Found");
                }))
                .map(user -> {
                    log.info("user = " + user.getUser() + ", id = " + user.getId() + ", role = " + user.getRole());
                    return ResponseEntity.status(HttpStatus.FOUND).body(User.builder().user(user.getUser()).build());
                })
                .onErrorResume(throwable -> {
                    log.error("\n\n ***************** {}", throwable.getMessage());
                    return Mono.fromCallable(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
                });
    }
}
