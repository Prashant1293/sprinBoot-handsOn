package edu.knoldus.com.handsonspringboot.exceptions;

public class InvalidNameException extends RuntimeException {
    
    public InvalidNameException(String name) {
        super(name + " is invalid.");
    }
}
