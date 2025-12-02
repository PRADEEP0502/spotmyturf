package com.spotmyturf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spotmyturf.backend.model.Slot;
import com.spotmyturf.backend.service.SlotService;

import java.util.List;

@RestController
@RequestMapping("/api/slot")
public class SlotController {

    @Autowired
    private SlotService service;

    @GetMapping("/{turfId}/{date}")
    public List<Slot> getAll(@PathVariable Long turfId,
                             @PathVariable String date) {
        return service.getSlots(turfId, date);
    }

    @GetMapping("/morning/{turfId}/{date}")
    public List<Slot> getMorning(@PathVariable Long turfId,
                                 @PathVariable String date) {
        return service.getMorningSlots(turfId, date);
    }

    @GetMapping("/night/{turfId}/{date}")
    public List<Slot> getNight(@PathVariable Long turfId,
                               @PathVariable String date) {
        return service.getNightSlots(turfId, date);
    }

    @PostMapping("/book/{slotId}")
    public String bookSlot(@PathVariable Long slotId) {
        return service.bookSlot(slotId);
    }
}
