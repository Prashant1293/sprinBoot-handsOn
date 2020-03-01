package edu.knoldus.com.handsonspringboot.repository.couchbase.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Getter
public class CouchbaseConfiguration {
    
    @Value("${reactive.couchbase.bootstrap-hosts}")
    private List<String> couchbaseHosts;
    
    @Value("${reactive.couchbase.bucket.name}")
    private String couchbaseBucketName;
    
    @Value("${reactive.couchbase.bucket.password}")
    private String couchbaseBucketPassword;
    
    @Value("${reactive.couchbase.bucket.username}")
    private String couchbaseUsername;
}
