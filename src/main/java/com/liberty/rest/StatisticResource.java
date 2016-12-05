package com.liberty.rest;

import com.liberty.model.PlayerStatistic;
import com.liberty.repositories.PlayerStatisticRepository;

import com.liberty.service.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Dmytro_Kovalskyi.
 * @since 23.05.2016.
 */
@RestController
@RequestMapping("/api/statistic")
@CrossOrigin(origins = "*")
@Slf4j
public class StatisticResource {

    @Autowired
    private PlayerStatisticsService playerStatisticsService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public PlayerStatistic get(@PathVariable Long id) {
        return playerStatisticsService.findById(id);
    }
}
