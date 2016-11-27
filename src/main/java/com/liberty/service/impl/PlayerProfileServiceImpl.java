package com.liberty.service.impl;

import com.liberty.model.PlayerProfile;
import com.liberty.repositories.PlayerProfileRepository;
import com.liberty.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PlayerProfileServiceImpl implements PlayerProfileService {

    @Autowired
    private PlayerProfileRepository playerProfileRepository;

    @Override
    public PlayerProfile findById(Long playerId) {
        return playerProfileRepository.findOne(playerId);
    }

    @Override
    public Page<PlayerProfile> findAll(Integer page,
                                       Integer pageSize,
                                       String[] sortProperties,
                                       Sort.Direction sortDirection) {
        return playerProfileRepository.findAll(
                new PageRequest(page, pageSize, sortDirection, sortProperties)
        );
    }
}
