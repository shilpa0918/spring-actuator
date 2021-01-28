package com.spring.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/getusers")
    public List<User> getUser(){
        return userRepo.getAllUsers();
    }


}
