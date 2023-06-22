package fr.bracchi.myApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.bracchi.myApi.model.User;

@Service
public class UserService {
    ArrayList<User> users = new ArrayList<User>();

    public UserService() {
        users = new ArrayList<User>();

        this.users.add(new User(1, "Romain", 12));
        this.users.add(new User(2, "Camille", 14));
        this.users.add(new User(3, "Sylviane", 90));
    }
  
    public User getUser(Integer id) {
    
        for (User user : users) {
            if (user.getId() == id) {
            return user;
            }
        } 
    return null;
    }
    
}
