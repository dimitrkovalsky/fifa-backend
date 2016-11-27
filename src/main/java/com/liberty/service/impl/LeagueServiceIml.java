package com.liberty.service.impl;

import com.liberty.model.League;
import com.liberty.repositories.LeagueRepository;
import com.liberty.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class LeagueServiceIml implements LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    @Override
    public League findById(Long leagueId) {
        return leagueRepository.findOne(leagueId);
    }

    @Override
    public Page<League> findAll(Integer page, Integer pageSize, String[] sortProperties, Sort.Direction sortDirection) {
        return leagueRepository.findAll(
                new PageRequest(page, pageSize, sortDirection, sortProperties)
        );
    }
}
