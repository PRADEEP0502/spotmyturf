package com.spotmyturf.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.spotmyturf.backend.dto.TurfRequest;
import com.spotmyturf.backend.model.Turf;
import com.spotmyturf.backend.repository.TurfRepository;
import com.spotmyturf.backend.service.TurfService;

import java.util.List;

@Service
public class TurfServiceImpl implements TurfService {

    @Autowired
    private TurfRepository repo;

    @Override
    public String addTurf(TurfRequest req) {

        Turf t = new Turf();
        t.setTurfName(req.getTurfName());
        t.setLocation(req.getLocation());
        t.setSportType(req.getSportType());
        t.setOpenTime(req.getOpenTime());
        t.setCloseTime(req.getCloseTime());
        t.setOwnerId(req.getOwnerId());

        repo.save(t);

        return "Turf Added Successfully";
    }

    @Override
    public List<Turf> getOwnerTurfs(Long ownerId) {
        return repo.findByOwnerId(ownerId);
    }

    @Override
    public List<Turf> getAllTurfs() {
        return repo.findAll();
    }
}
