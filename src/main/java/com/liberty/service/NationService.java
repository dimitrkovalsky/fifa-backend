package com.liberty.service;

import com.liberty.model.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface NationService {

    Nation findById(Long nationId);

    Page<Nation> findAll(Integer page, Integer pageSize, String[] sortProperties, Sort.Direction sortDirection);
}
