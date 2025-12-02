package com.spotmyturf.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.spotmyturf.backend.dto.OwnerRequest;
import com.spotmyturf.backend.model.Owner;
import com.spotmyturf.backend.repository.OwnerRepository;
import com.spotmyturf.backend.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository repo;

    @Override
    public String register(OwnerRequest req) {

        if(repo.existsByPhone(req.getPhone())) {
            return "Owner already exists";
        }

        Owner o = new Owner();
        o.setName(req.getName());
        o.setPhone(req.getPhone());
        o.setEmail(req.getEmail());
        o.setPassword(req.getPassword());
        o.setStatus("PENDING");

        repo.save(o);

        return "Owner registered. Please wait for admin approval.";
    }

    @Override
    public Owner login(String phone, String password) {

        Owner o = repo.findByPhone(phone);

        if(o == null) return null;
        if(!o.getPassword().equals(password)) return null;

        if(!o.getStatus().equals("APPROVED")) {
            return null; // Only approved owners can login
        }

        return o;
    }
}
