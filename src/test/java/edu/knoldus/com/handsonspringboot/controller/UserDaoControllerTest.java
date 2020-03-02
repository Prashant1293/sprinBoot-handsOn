package edu.knoldus.com.handsonspringboot.controller;

import edu.knoldus.com.handsonspringboot.repository.UserDaoLayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

//import org.mockito.junit.MockitoJUnitRunner;

@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
// Would load the application context so that the application starts to run during the test phase.
@RunWith(MockitoJUnitRunner.class)
// would not start the application during test phase, any one of these 2 annotations can be used.
public class UserDaoControllerTest {
    
    @Mock
    private UserDaoLayer userDaoLayer;
    
    @InjectMocks
    private UserDaoController userDaoController;
    
    @Test
    public void shouldTestTheGetUserFunctionality() {
        String user = "---Prashant::Sharma---USER";
        
        when(userDaoLayer.getUsers(anyString())).thenReturn(Arrays.asList(user, user));
        
        List<String> users = userDaoController.getUsers();
        
        assertFalse(users.isEmpty());
        assertEquals(user, users.get(0));
    }
    
    @Test
    public void shouldTestTheGetUsersByIdFunctionality() {
        String id = "ID";
        String queryParam = "QP";
        String user = "USER";
        
        when(userDaoLayer.getUsers(anyString())).thenReturn(Collections.singletonList(user));
        
        List<String> usersById = userDaoController.getUsersById(id, queryParam);
        
        assertFalse(usersById.isEmpty());
        assertEquals(user, usersById.get(0));
    }
}
