package com.liberty.service;

import com.liberty.model.League;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface LeagueService {

    League findById(Long leagueId);

    Page<League> findAll(Integer page, Integer pageSize, String[] sortProperties, Sort.Direction sortDirection);
}
