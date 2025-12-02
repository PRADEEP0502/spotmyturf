package com.spotmyturf.backend.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.spotmyturf.backend.service.UserService;
import com.spotmyturf.backend.dto.UserRequest;
import com.spotmyturf.backend.model.User;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public String register(@RequestBody UserRequest req) {
        return service.register(req);
    }

    @PostMapping("/login")
    public User login(@RequestParam String phone,
                      @RequestParam String password) {
        return service.login(phone, password);
    }
}

