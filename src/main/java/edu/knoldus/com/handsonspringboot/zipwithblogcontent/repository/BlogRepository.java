package edu.knoldus.com.handsonspringboot.zipwithblogcontent.repository;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class BlogRepository {
    private static Map<Integer, String> blogs = new HashMap<>();
    
    static {
        blogs.put(1, "Spring-boot-controllers");
        blogs.put(2, "Spring-boot-web-client");
        blogs.put(3, "Spring-boot-web-flux");
        blogs.put(4, "Spring-boot-reactive-api");
        blogs.put(5, "Spring-boot-web-client-testing");
    }
    
    public Mono<String> getBlogIfPresent(int id) {
        if (blogs.containsKey(id)) {
            return Mono.fromCallable(() -> blogs.get(id));
        }
        
        return Mono.empty();
    }
    
    public Mono<Integer> getBlogRating(int blogId) {
        if (blogs.containsKey(blogId)) {
            return Mono.fromCallable(() -> blogs.get(blogId).split("-").length);
        }
        
        return Mono.empty();
    }
}
