package com.spotmyturf.backend.service;

import com.spotmyturf.backend.dto.AdminLoginRequest;
import com.spotmyturf.backend.model.Admin;

public interface AdminService {

    String register(Admin admin);

    Admin login(AdminLoginRequest request);
}
