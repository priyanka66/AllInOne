package com.allInOne.allInOneV1.controller;


import com.allInOne.allInOneV1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.allInOne.allInOneV1.repository.UserRepository;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/add", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity createUser(@RequestBody User newUser) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(newUser);
    }


    @RequestMapping(path="/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}