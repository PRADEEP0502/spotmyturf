package com.spotmyturf.backend.service;

import com.spotmyturf.backend.dto.UserDashboardResponse;

public interface UserDashboardService {
    UserDashboardResponse getDashboard(Long userId);
}
