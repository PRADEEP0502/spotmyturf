package com.spotmyturf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spotmyturf.backend.model.Admin;
import com.spotmyturf.backend.model.Owner;
import com.spotmyturf.backend.model.Turf;
import com.spotmyturf.backend.model.Booking;
import com.spotmyturf.backend.model.User;

import com.spotmyturf.backend.repository.AdminRepository;
import com.spotmyturf.backend.repository.OwnerRepository;
import com.spotmyturf.backend.repository.TurfRepository;
import com.spotmyturf.backend.repository.BookingRepository;
import com.spotmyturf.backend.repository.UserRepository;

import com.spotmyturf.backend.dto.AdminLoginRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private OwnerRepository ownerRepo;

    @Autowired
    private TurfRepository turfRepo;

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private UserRepository userRepo;

    // ADMIN REGISTER (ONE TIME)
    @PostMapping("/register")
    public String register(@RequestBody Admin admin) {
        if(adminRepo.findByEmail(admin.getEmail()) != null)
            return "Admin already exists";
        adminRepo.save(admin);
        return "Admin created";
    }

    // ADMIN LOGIN
    @PostMapping("/login")
    public Object login(@RequestBody AdminLoginRequest req) {
        Admin admin = adminRepo.findByEmail(req.getEmail());
        if(admin == null) return "Invalid credentials";
        if(!admin.getPassword().equals(req.getPassword())) return "Invalid credentials";
        return admin;
    }

    // OWNER APPROVAL
    @PatchMapping("/approve-owner/{id}")
    public String approveOwner(@PathVariable Long id) {
        Owner o = ownerRepo.findById(id).orElse(null);
        if(o == null) return "Owner not found";
        o.setStatus("APPROVED");
        ownerRepo.save(o);
        return "Owner approved";
    }

    @PatchMapping("/reject-owner/{id}")
    public String rejectOwner(@PathVariable Long id) {
        Owner o = ownerRepo.findById(id).orElse(null);
        if(o == null) return "Owner not found";
        o.setStatus("REJECTED");
        ownerRepo.save(o);
        return "Owner rejected";
    }

    @GetMapping("/owners/pending")
    public List<Owner> pendingOwners() {
        return ownerRepo.findByStatus("PENDING");
    }

    @GetMapping("/owners/all")
    public List<Owner> allOwners() {
        return ownerRepo.findAll();
    }

    // TURF APPROVAL
    @PatchMapping("/approve-turf/{id}")
    public String approveTurf(@PathVariable Long id) {
        Turf t = turfRepo.findById(id).orElse(null);
        if(t == null) return "Turf not found";
        t.setStatus("APPROVED");
        t.setActive(true);
        turfRepo.save(t);
        return "Turf approved";
    }

    @PatchMapping("/reject-turf/{id}")
    public String rejectTurf(@PathVariable Long id) {
        Turf t = turfRepo.findById(id).orElse(null);
        if(t == null) return "Turf not found";
        t.setStatus("REJECTED");
        t.setActive(false);
        turfRepo.save(t);
        return "Turf rejected";
    }

    @GetMapping("/turfs/pending")
    public List<Turf> pendingTurfs() {
        return turfRepo.findByStatus("PENDING");
    }

    @GetMapping("/turfs/all")
    public List<Turf> allTurfs() {
        return turfRepo.findAll();
    }

    // USERS & BOOKINGS
    @GetMapping("/users/all")
    public List<User> allUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/bookings/all")
    public List<Booking> allBookings() {
        return bookingRepo.findAll();
    }
}
