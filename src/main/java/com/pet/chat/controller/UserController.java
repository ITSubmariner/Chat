package com.pet.chat.controller;

import com.pet.chat.domain.requestParams.UserParameters;
import com.pet.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void add(@RequestBody UserParameters params) {
        userRepository.create(params.getUsername(), params.getPassword());
    }

}
