package com.liberty.service;

import com.liberty.model.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface ClubService {

    Club findById(Long clubId);

    Page<Club> findAll(Integer page, Integer pageSize, String[] sortProperties, Sort.Direction sortDirection);
}
