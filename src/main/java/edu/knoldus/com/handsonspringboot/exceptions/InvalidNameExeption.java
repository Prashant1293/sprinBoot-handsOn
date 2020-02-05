package edu.knoldus.com.handsonspringboot.exceptions;

public class InvalidNameExeption extends RuntimeException {
    
    public InvalidNameExeption(String name) {
        super(name + " is invalid.");
    }
}
