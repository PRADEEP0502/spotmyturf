package com.spotmyturf.backend.service;

import com.spotmyturf.backend.dto.OwnerRequest;
import com.spotmyturf.backend.model.Owner;

public interface OwnerService {

    String register(OwnerRequest req);

    Owner login(String phone, String password);
}
