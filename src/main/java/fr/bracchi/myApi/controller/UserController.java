package fr.bracchi.myApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.bracchi.myApi.model.User;
import fr.bracchi.myApi.service.UserService;

@RestController
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }   

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        User user = userService.getUser(id);
        return user;
    }

    /*
        requette Postman GET pour afficher le user id 1
        http://localhost:8080/user?id=1
    */

    @PostMapping("/user")
    public User createUser(@RequestBody UserRequest userRequest) {
        String name = userRequest.getName();
        int age = userRequest.getAge();
        
        User user = userService.createUser(name, age);
        return user;
    }

    /*
        requette Postman Post pour ajouter le user
        http://localhost:8080/user?name=tata&age=22
    */
    
}
