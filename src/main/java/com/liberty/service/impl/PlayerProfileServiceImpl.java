package com.liberty.service.impl;

import com.liberty.model.PlayerProfile;
import com.liberty.repositories.PlayerProfileRepository;
import com.liberty.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileServiceImpl implements PlayerProfileService {

    @Autowired
    private PlayerProfileRepository playerProfileRepository;

    @Override
    public PlayerProfile findById(Long playerId) {
        return playerProfileRepository.findOne(playerId);
    }

    @Override
    public List<PlayerProfile> findAll() {
        return playerProfileRepository.findAll();
    }
}
