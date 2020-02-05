package edu.knoldus.com.handsonspringboot.controller;

import edu.knoldus.com.handsonspringboot.exceptions.InvalidNameException;
import edu.knoldus.com.handsonspringboot.models.User;
import edu.knoldus.com.handsonspringboot.repository.UserDaoLayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/edu")
@Slf4j
public class SpringRestController {
    
    @Value("${name:NOT-FOUND}")
    private String name;
    
    @Autowired
    private UserDaoLayer reactiveCouchbaseRepository;
    
    /*public SpringRestController(ReactiveCouchbaseRepository reactiveCouchbaseRepository) {
        this.reactiveCouchbaseRepository = reactiveCouchbaseRepository;
    }
    */
    @GetMapping(path = "/users")
    public List<String> getUsers() {
        return reactiveCouchbaseRepository.getUsers("---Prashant::Sharma---" + name);
    }
    
    @GetMapping(path = "/users/{value}/value", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<String> getUsersById(@PathVariable(value = "value") String id,
                                     @RequestParam(required = false, value = "qP",
                                             defaultValue = "DEFAULT") String queryParam1) {
        return reactiveCouchbaseRepository.getUsers(id + queryParam1);
    }
    
    @PostMapping(path = "/user/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@Valid @RequestBody User user/*, Mono<BindingResult> bindingResult*/) {
        
        /*if (bindingResult.onErrorContinue()) {
            return "No value can be returned as object cannot be transformed in User.";
        }*/
        
        /*bindingResult.onErrorContinue((throwable, error) -> {
            log.error("Error observed = {}.", throwable.getMessage());
        }).map(err -> {
            if (err.hasErrors()) {
                return "No value can be returned as object cannot be transformed in User.";
            }
            
            return "All Good";
        });*/
        
        return reactiveCouchbaseRepository.getUsers(user.getName()).get(0);
    }
    
    @GetMapping("/name/{name}")
    public String getName(@PathVariable String name) {
        
        if (name.length() < 2) {
            throw new InvalidNameException(name);
        }
        
        return name;
    }
    
    // We can have exception handling at a local level like this or we can have the exception handling at the global level.
    // In the case of global level handling we will have to make a class annotated with @RestControllerAdvice
    // or (@ControllerAdvice + @Component).
    @ExceptionHandler(value = InvalidNameException.class)
    public ResponseEntity<String> handleNameException(InvalidNameException invalidNameExeption) {
        return ResponseEntity.status(422).body(invalidNameExeption.getMessage());
    }
}
