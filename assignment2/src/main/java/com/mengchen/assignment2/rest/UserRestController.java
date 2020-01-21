package com.mengchen.assignment2.rest;


import com.mengchen.assignment2.entity.User;
import com.mengchen.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService){
        this.userService = theUserService;
    }

    // expose "/users" to return user list
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.listAllUser();
    }

    // add mapping for GET /users/{email}

    @GetMapping("/users/{theEmail}")
    public User getUser(@PathVariable String theEmail){
        User theUser = userService.findByEmail(theEmail);

        if(theUser == null){
            throw new RuntimeException("User email did not exist - " + theEmail);
        }

        return theUser;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User theUser){

//        theUser.setId(UUID.randomUUID().toString());
        theUser.setCreatedTime(LocalDateTime.now().toString());
        theUser.setUpdateTime(LocalDateTime.now().toString());

        userService.updateUser(theUser);

        return theUser;
    }

    @PutMapping("/user/self")
    public User updateUser(@RequestBody User theUser){
        String createTime = theUser.getCreatedTime();
        theUser.setCreatedTime(createTime);
        theUser.setUpdateTime(LocalDateTime.now().toString());

        userService.updateUser(theUser);
        return theUser;
    }


}
