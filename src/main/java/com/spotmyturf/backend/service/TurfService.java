package com.spotmyturf.backend.service;

import java.util.List;
import com.spotmyturf.backend.dto.TurfRequest;
import com.spotmyturf.backend.model.Turf;

public interface TurfService {
    String addTurf(TurfRequest req);
    List<Turf> getOwnerTurfs(Long ownerId);
    List<Turf> getAllTurfs();
}
