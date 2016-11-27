package com.liberty.service.impl;

import com.liberty.model.Nation;
import com.liberty.repositories.NationRepository;
import com.liberty.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NationServiceImpl implements NationService {

    @Autowired
    private NationRepository nationRepository;

    @Override
    public Nation findById(Long nationId) {
        return nationRepository.findOne(nationId);
    }

    @Override
    public Page<Nation> findAll(Integer page, Integer pageSize, String[] sortProperties, Sort.Direction sortDirection) {
        return nationRepository.findAll(
                new PageRequest(page, pageSize, sortDirection, sortProperties)
        );
    }
}
