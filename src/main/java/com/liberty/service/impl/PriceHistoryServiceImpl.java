package com.liberty.service.impl;

import com.liberty.model.PlayerStatistic;
import com.liberty.model.PriceHistory;
import com.liberty.repositories.PriceHistoryRepository;
import com.liberty.service.PriceHistoryService;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PriceHistoryServiceImpl implements PriceHistoryService {

    @Autowired
    private PriceHistoryRepository historyRepository;

    @Override
    public Map<Long, PlayerStatistic.HistoryPoint> getHistory(Long playerId) {

        PriceHistory history = historyRepository.findOne(playerId);
        if (history == null) {
            return new HashMap<>();
        }

        Set<Long> dates = history.getHistory().keySet();
        Map<Long, Map<Integer, Integer>> historyMap = history.getHistory();

        SortedMap<Long, PlayerStatistic.HistoryPoint> collectedHistory = new TreeMap<>();
        dates.forEach(d -> {
                    PlayerStatistic.HistoryPoint point = buildHistory(historyMap.get(d));
                    collectedHistory.put(d, point);
                }
        );
        return collectedHistory;
    }

    private PlayerStatistic.HistoryPoint buildHistory(Map<Integer, Integer> priceDistribution) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        priceDistribution.forEach((k, v) -> {
            for (int i = 0; i < v; i++) {
                stats.addValue(k);
            }
        });

        return new PlayerStatistic.HistoryPoint((long) stats.getMin(), (long) stats.getPercentile(50));
    }
}
