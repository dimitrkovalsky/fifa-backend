package com.liberty.service.impl;

import com.liberty.model.PlayerStatistic;
import com.liberty.repositories.PlayerStatisticRepository;
import com.liberty.service.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatisticsServiceImpl implements PlayerStatisticsService {

    @Autowired
    private PlayerStatisticRepository playerStatisticRepository;

    @Override
    public PlayerStatistic findById(Long playerId) {
        return playerStatisticRepository.findOne(playerId);
    }
}
