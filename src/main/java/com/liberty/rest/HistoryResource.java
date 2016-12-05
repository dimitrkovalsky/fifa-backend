package com.liberty.rest;

import com.liberty.model.PlayerStatistic;

import com.liberty.service.PriceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Dmytro_Kovalskyi.
 * @since 23.05.2016.
 */
@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")
@Slf4j
public class HistoryResource {

    @Autowired
    private PriceHistoryService priceHistoryService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Map<Long, PlayerStatistic.HistoryPoint> get(@PathVariable Long id) {
        return priceHistoryService.getHistory(id);
    }
}
