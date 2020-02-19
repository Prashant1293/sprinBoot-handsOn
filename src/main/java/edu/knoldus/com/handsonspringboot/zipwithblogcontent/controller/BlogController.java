package edu.knoldus.com.handsonspringboot.zipwithblogcontent.controller;

import edu.knoldus.com.handsonspringboot.zipwithblogcontent.repository.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/edu")
@Slf4j
public class BlogController {
    /* Links to the blog here https://blog.knoldus.com/reactive-java-combining-mono/ */
    
    private BlogRepository repository;
    
    public BlogController(BlogRepository repo) {
        this.repository = repo;
    }
    
    @GetMapping("/blogs/{blogId}")
    public Mono<String> getBlogs(@PathVariable int blogId) {
        
        return repository.getBlogIfPresent(blogId)
                .switchIfEmpty(Mono.fromCallable(() -> "No blog found with this id = " + blogId))
                .zipWith(repository.getBlogRating(blogId)
                        .switchIfEmpty(Mono.fromCallable(() -> -10)))
                .map(tuple2 -> {
                    log.info("Tuple created with blog and it's rating as {}.",
                            "blog:" + tuple2.getT1() + ",rating:" + tuple2.getT2());
                    
                    return "blog:" + tuple2.getT1() + ",rating:" + tuple2.getT2();
                });
    }
    
}
