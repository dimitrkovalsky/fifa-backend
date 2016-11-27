package com.liberty.service;

import com.liberty.model.PlayerStatistic;

import java.util.Map;

public interface PriceHistoryService {

    Map<Long, PlayerStatistic.HistoryPoint> getHistory(Long playerId);
}
