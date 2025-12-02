package com.spotmyturf.backend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.spotmyturf.backend.dto.OwnerRequest;
import com.spotmyturf.backend.service.OwnerService;
import com.spotmyturf.backend.model.Owner;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @PostMapping("/register")
    public String register(@RequestBody OwnerRequest req) {
        return service.register(req);
    }

    @PostMapping("/login")
    public Owner login(@RequestParam String phone,
                       @RequestParam String password) {
        return service.login(phone, password);
    }
}
