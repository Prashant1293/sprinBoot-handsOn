package edu.knoldus.com.handsonspringboot.repository;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoLayer {
    
    private static List<String> users = new ArrayList<>();
    
    public List<String> getUsers(@NonNull String user) {
        users.add(user);
        return users;
    }
}
