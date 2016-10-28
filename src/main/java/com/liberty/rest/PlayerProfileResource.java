package com.liberty.rest;

import com.liberty.model.PlayerProfile;
import com.liberty.repositories.PlayerProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dmytro_Kovalskyi.
 * @since 19.05.2016.
 */
@RestController
@RequestMapping("/api/profile")
public class PlayerProfileResource {

  @Autowired
  private PlayerProfileRepository playerProfileRepository;

  @RequestMapping(method = RequestMethod.GET)
  public List<PlayerProfile> getAll() {
    return playerProfileRepository.findAll();
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public PlayerProfile get(@PathVariable Long id) {
    return playerProfileRepository.findOne(id);
  }
}
