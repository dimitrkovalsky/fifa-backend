package com.liberty.rest;

import com.liberty.model.League;
import com.liberty.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import static com.liberty.util.ControllerUtils.splitRequestParameter;


@RestController
@RequestMapping("/api/leagues")
@CrossOrigin(origins = "*")
public class LeagueResource {

    @Autowired
    private LeagueService leagueService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public League findById(@PathVariable Long id) {
        return leagueService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<League> findAll(@RequestParam("page") Integer page,
                                @RequestParam("pageSize") Integer pageSize,
                                @RequestParam("sortProperties") String sortProperties,
                                @RequestParam("sortDirection") Sort.Direction sortDirection) {
        return leagueService.findAll(
                page, pageSize, splitRequestParameter(sortProperties), sortDirection
        );
    }
}
