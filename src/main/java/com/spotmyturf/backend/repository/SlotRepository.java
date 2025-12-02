package com.spotmyturf.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spotmyturf.backend.model.Slot;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {

    List<Slot> findByTurfIdAndDate(Long turfId, String date);

    List<Slot> findByTurfIdAndDateAndSlotType(Long turfId, String date, String slotType);
}
