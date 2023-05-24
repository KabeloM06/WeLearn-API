package com.kabelo.WeLearn.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    // Get all users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    // Get 1 user
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return userDaoService.findOne(id);
    }

    // Create a user
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        userDaoService.save(user);
    }
}
