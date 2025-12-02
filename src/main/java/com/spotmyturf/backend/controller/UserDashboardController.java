package com.spotmyturf.backend.controller;

import com.spotmyturf.backend.dto.UserDashboardResponse;
import com.spotmyturf.backend.service.UserDashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/dashboard")
public class UserDashboardController {

    @Autowired
    private UserDashboardService service;

    @GetMapping("/{userId}")
    public UserDashboardResponse getDashboard(@PathVariable Long userId) {
        return service.getDashboard(userId);
    }
}
