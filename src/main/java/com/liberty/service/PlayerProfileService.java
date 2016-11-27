package com.liberty.service;

import com.liberty.model.PlayerProfile;

import java.util.List;

public interface PlayerProfileService {

    PlayerProfile findById(Long playerId);

    List<PlayerProfile> findAll();
}
