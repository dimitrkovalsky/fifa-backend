package com.liberty.rest;

import com.liberty.converter.PlayerProfileConverter;
import com.liberty.dto.PlayerProfileTO;

import com.liberty.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

import static com.liberty.util.ControllerUtils.splitRequestParameter;

/**
 * @author Dmytro_Kovalskyi.
 * @since 19.05.2016.
 */
@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "*")
public class PlayerProfileResource {

    @Autowired
    private PlayerProfileService playerProfileService;
    @Autowired
    private PlayerProfileConverter playerProfileConverter;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Resource<PlayerProfileTO>> getAll(@RequestParam("page") Integer page,
                                                  @RequestParam("pageSize") Integer pageSize,
                                                  @RequestParam("sortProperties") String sortProperties,
                                                  @RequestParam("sortDirection") Direction sortDirection) {
        return playerProfileService.findAll(
                page, pageSize, splitRequestParameter(sortProperties), sortDirection
        ).map(playerProfile -> playerProfileConverter.convert(playerProfile));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Resource<PlayerProfileTO> get(@PathVariable Long id) {
        return playerProfileConverter.convert(playerProfileService.findById(id));
    }
}
