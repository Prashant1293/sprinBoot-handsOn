package edu.knoldus.com.handsonspringboot.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class User {
    
    @NonNull
    String name;
    
    @Min(value = 18, message = "Age cannot be less than 18 years.")
    int age;
    
    String address;
}
