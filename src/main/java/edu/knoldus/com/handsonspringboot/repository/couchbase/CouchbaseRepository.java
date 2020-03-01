package edu.knoldus.com.handsonspringboot.repository.couchbase;

import edu.knoldus.com.handsonspringboot.repository.couchbase.model.User;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import reactor.core.publisher.Mono;

public interface CouchbaseRepository extends ReactiveCouchbaseRepository<User, String> {
    
    @Override
    Mono<User> findById(String s);
}
