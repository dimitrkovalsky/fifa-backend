package com.liberty.rest;

import com.liberty.model.PlayerStatistic;

import com.liberty.service.PriceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    private PriceHistoryService priceHistoryService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Map<Long, PlayerStatistic.HistoryPoint> get(@PathVariable Long id) {
        return priceHistoryService.getHistory(id);
    }
}
