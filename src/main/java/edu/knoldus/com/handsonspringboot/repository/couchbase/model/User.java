package edu.knoldus.com.handsonspringboot.repository.couchbase.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@Getter
@AllArgsConstructor
public class User {
    
    @Id
    String id;
    
    @Field
    String user;
    
    @Field
    String role;
    
}
