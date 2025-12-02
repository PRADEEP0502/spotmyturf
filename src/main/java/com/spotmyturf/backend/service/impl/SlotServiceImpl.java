package com.spotmyturf.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotmyturf.backend.model.Slot;
import com.spotmyturf.backend.repository.SlotRepository;
import com.spotmyturf.backend.service.SlotService;

import java.util.*;

@Service
public class SlotServiceImpl implements SlotService {

    @Autowired
    private SlotRepository repo;

    private List<String[]> morningSlots = Arrays.asList(
        new String[]{"06:00", "07:00"},
        new String[]{"07:00", "08:00"},
        new String[]{"08:00", "09:00"},
        new String[]{"09:00", "10:00"},
        new String[]{"10:00", "11:00"},
        new String[]{"11:00", "12:00"}
    );

    private List<String[]> nightSlots = Arrays.asList(
        new String[]{"12:00", "13:00"},
        new String[]{"13:00", "14:00"},
        new String[]{"14:00", "15:00"},
        new String[]{"15:00", "16:00"},
        new String[]{"16:00", "17:00"},
        new String[]{"17:00", "18:00"},
        new String[]{"18:00", "19:00"},
        new String[]{"19:00", "20:00"},
        new String[]{"20:00", "21:00"},
        new String[]{"21:00", "22:00"},
        new String[]{"22:00", "23:00"},
        new String[]{"23:00", "00:00"},
        new String[]{"00:00", "01:00"},
        new String[]{"01:00", "02:00"},
        new String[]{"02:00", "03:00"},
        new String[]{"03:00", "04:00"},
        new String[]{"04:00", "05:00"},
        new String[]{"05:00", "06:00"}
    );

    @Override
    public void generateSlots(Long turfId, String date) {

        if (!repo.findByTurfIdAndDate(turfId, date).isEmpty()) {
            return; // slots already created
        }

        for (String[] slot : morningSlots) {
            Slot s = new Slot();
            s.setTurfId(turfId);
            s.setStartTime(slot[0]);
            s.setEndTime(slot[1]);
            s.setSlotType("MORNING");
            s.setDate(date);
            s.setBooked(false);
            repo.save(s);
        }

        for (String[] slot : nightSlots) {
            Slot s = new Slot();
            s.setTurfId(turfId);
            s.setStartTime(slot[0]);
            s.setEndTime(slot[1]);
            s.setSlotType("NIGHT");
            s.setDate(date);
            s.setBooked(false);
            repo.save(s);
        }
    }

    @Override
    public List<Slot> getSlots(Long turfId, String date) {
        generateSlots(turfId, date);
        return repo.findByTurfIdAndDate(turfId, date);
    }

    @Override
    public List<Slot> getMorningSlots(Long turfId, String date) {
        generateSlots(turfId, date);
        return repo.findByTurfIdAndDateAndSlotType(turfId, date, "MORNING");
    }

    @Override
    public List<Slot> getNightSlots(Long turfId, String date) {
        generateSlots(turfId, date);
        return repo.findByTurfIdAndDateAndSlotType(turfId, date, "NIGHT");
    }

    @Override
    public String bookSlot(Long slotId) {
        Slot s = repo.findById(slotId).orElse(null);
        if (s == null) return "Slot not found";

        if (s.isBooked()) return "Already booked";

        s.setBooked(true);
        repo.save(s);
        return "Slot Booked Successfully";
    }
}
