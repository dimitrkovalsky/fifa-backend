package com.liberty.service;

import com.liberty.model.PlayerStatistic;

public interface PlayerStatisticsService {

    PlayerStatistic findById(Long playerId);
}
