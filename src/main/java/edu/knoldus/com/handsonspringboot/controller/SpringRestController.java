package edu.knoldus.com.handsonspringboot.controller;

import edu.knoldus.com.handsonspringboot.repository.ReactiveCouchbaseRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/edu")
public class SpringRestController {
    
    @Value("${name:NOTFOUND}")
    private String name;
    
    private ReactiveCouchbaseRepository reactiveCouchbaseRepository;
    
    public SpringRestController(ReactiveCouchbaseRepository reactiveCouchbaseRepository) {
        this.reactiveCouchbaseRepository = reactiveCouchbaseRepository;
    }
    
    @GetMapping(path = "/users")
    public List<String> getUsers() {
        return reactiveCouchbaseRepository.getUsers("PrashantSharma--" + name);
    }
    
    @GetMapping(path = "/users/{id}/value", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<String> getUsersById(@PathVariable String id, @RequestParam(required = false) String queryParam1) {
        return reactiveCouchbaseRepository.getUsers(id + queryParam1);
    }
}
