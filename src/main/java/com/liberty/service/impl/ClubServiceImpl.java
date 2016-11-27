package com.liberty.service.impl;

import com.liberty.model.Club;
import com.liberty.repositories.ClubRepository;
import com.liberty.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public Club findById(Long clubId) {
        return clubRepository.findOne(clubId);
    }

    @Override
    public Page<Club> findAll(Integer page, Integer pageSize, String[] sortProperties, Sort.Direction sortDirection) {
        return clubRepository.findAll(
                new PageRequest(page, pageSize, sortDirection, sortProperties)
        );
    }
}
