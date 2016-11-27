package com.liberty.service;

import com.liberty.model.PlayerProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface PlayerProfileService {

    PlayerProfile findById(Long playerId);

    Page<PlayerProfile> findAll(Integer page, Integer pageSize, String[] sortProperties, Sort.Direction sortDirection);
}
