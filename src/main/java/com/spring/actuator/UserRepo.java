package com.spring.actuator;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepo {

    public List<User> getAllUsers(){
        return Stream.of(
                new User(1,"shilpa","s@gmail.com","active"),
                new User(2,"smita","s@gmail.com","inActive"),
                new User(3,"madhuri","m@gmail.com","active"),
                new User(4,"prati","p@gmail.com","inActive")
                ).collect(Collectors.toList());
    }
    public long getStatus(String status){
        return getAllUsers().stream().filter(user->user.getStatus().equals(status)).count();
    }
}
