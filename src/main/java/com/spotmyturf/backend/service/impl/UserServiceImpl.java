package com.spotmyturf.backend.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.spotmyturf.backend.service.UserService;
import com.spotmyturf.backend.repository.UserRepository;
import com.spotmyturf.backend.dto.UserRequest;
import com.spotmyturf.backend.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public String register(UserRequest req) {

        if(repo.existsByPhone(req.getPhone())) {
            return "User already exists";
        }

        User u = new User();
        u.setName(req.getName());
        u.setPhone(req.getPhone());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        u.setRole("USER");

        repo.save(u);
        return "User registered";
    }

    @Override
    public User login(String phone, String password) {
        User u = repo.findByPhone(phone);

        if(u == null) return null;
        if(!u.getPassword().equals(password)) return null;

        return u;
    }
}
