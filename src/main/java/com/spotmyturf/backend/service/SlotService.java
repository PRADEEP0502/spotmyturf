package com.spotmyturf.backend.service;

import java.util.List;
import com.spotmyturf.backend.model.Slot;

public interface SlotService {

    void generateSlots(Long turfId, String date);

    List<Slot> getSlots(Long turfId, String date);

    List<Slot> getMorningSlots(Long turfId, String date);

    List<Slot> getNightSlots(Long turfId, String date);

    String bookSlot(Long slotId);
}
