package com.spotmyturf.backend.controller;

import com.spotmyturf.backend.dto.OwnerDashboardResponse;
import com.spotmyturf.backend.service.OwnerDashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner/dashboard")
public class OwnerDashboardController {

    @Autowired
    private OwnerDashboardService service;

    @GetMapping("/{ownerId}")
    public OwnerDashboardResponse getDashboard(@PathVariable Long ownerId) {
        return service.getDashboard(ownerId);
    }
}
