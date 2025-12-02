package com.spotmyturf.backend.service;

import com.spotmyturf.backend.dto.OwnerDashboardResponse;

public interface OwnerDashboardService {
    OwnerDashboardResponse getDashboard(Long ownerId);
}
