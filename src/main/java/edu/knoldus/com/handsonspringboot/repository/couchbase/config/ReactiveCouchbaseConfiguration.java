package edu.knoldus.com.handsonspringboot.repository.couchbase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractReactiveCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

import java.util.List;

@Configuration
@EnableReactiveCouchbaseRepositories("edu.knoldus.com.handsonspringboot.repository")
public class ReactiveCouchbaseConfiguration extends AbstractReactiveCouchbaseConfiguration {
    
    private final CouchbaseConfiguration couchbaseConfiguration;
    
    public ReactiveCouchbaseConfiguration(CouchbaseConfiguration couchbaseConfiguration) {
        this.couchbaseConfiguration = couchbaseConfiguration;
    }
    
    @Override
    protected String getUsername() {
        return couchbaseConfiguration.getCouchbaseUsername();
    }
    
    @Override
    protected List<String> getBootstrapHosts() {
        return couchbaseConfiguration.getCouchbaseHosts();
    }
    
    @Override
    protected String getBucketName() {
        return couchbaseConfiguration.getCouchbaseBucketName();
    }
    
    @Override
    protected String getBucketPassword() {
        return couchbaseConfiguration.getCouchbaseBucketPassword();
    }
}
