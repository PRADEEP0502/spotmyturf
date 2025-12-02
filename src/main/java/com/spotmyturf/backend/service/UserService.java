package com.spotmyturf.backend.service;

import com.spotmyturf.backend.dto.UserRequest;
import com.spotmyturf.backend.model.User;

public interface UserService {
   String register(UserRequest request);
   User login(String phone, String password);
}
