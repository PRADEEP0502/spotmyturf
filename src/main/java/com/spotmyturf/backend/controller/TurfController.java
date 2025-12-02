package com.spotmyturf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spotmyturf.backend.dto.TurfRequest;
import com.spotmyturf.backend.model.Turf;
import com.spotmyturf.backend.service.TurfService;

import java.util.List;

@RestController
@RequestMapping("/api/turf")
public class TurfController {

    @Autowired
    private TurfService service;

    @PostMapping("/add")
    public String addTurf(@RequestBody TurfRequest req) {
        return service.addTurf(req);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Turf> getOwnerTurfs(@PathVariable Long ownerId) {
        return service.getOwnerTurfs(ownerId);
    }

    @GetMapping("/all")
    public List<Turf> getAll() {
        return service.getAllTurfs();
    }
}
