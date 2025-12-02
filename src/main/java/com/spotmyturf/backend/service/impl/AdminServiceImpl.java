package com.spotmyturf.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotmyturf.backend.dto.AdminLoginRequest;
import com.spotmyturf.backend.model.Admin;
import com.spotmyturf.backend.repository.AdminRepository;
import com.spotmyturf.backend.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository repo;

    @Override
    public String register(Admin admin) {

        if (repo.findByEmail(admin.getEmail()) != null) {
            return "Admin already exists";
        }

        repo.save(admin);
        return "Admin created successfully";
    }

    @Override
    public Admin login(AdminLoginRequest req) {

        Admin admin = repo.findByEmail(req.getEmail());
        if (admin == null) return null;

        if (!admin.getPassword().equals(req.getPassword())) {
            return null;
        }

        return admin;
    }
}
