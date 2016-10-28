package com.liberty.rest;

import com.liberty.model.PlayerStatistic;
import com.liberty.model.PriceHistory;
import com.liberty.repositories.PriceHistoryRepository;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Dmytro_Kovalskyi.
 * @since 23.05.2016.
 */
@RestController
@RequestMapping("/api/history")
@Slf4j
public class HistoryResource {

  @Autowired
  private PriceHistoryRepository historyRepository;

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public Map<Long, PlayerStatistic.HistoryPoint> get(@PathVariable Long id) {

    PriceHistory history = historyRepository.findOne(id);
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
