package com.liberty.rest;

import com.liberty.model.Club;
import com.liberty.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import static com.liberty.util.ControllerUtils.splitRequestParameter;


@RestController
@RequestMapping("/api/clubs")
@CrossOrigin(origins = "*")
public class ClubResource {

    @Autowired
    private ClubService clubService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Club findById(@PathVariable Long id) {
        return clubService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Club> findAll(@RequestParam("page") Integer page,
                              @RequestParam("pageSize") Integer pageSize,
                              @RequestParam("sortProperties") String sortProperties,
                              @RequestParam("sortDirection") Sort.Direction sortDirection) {
        return clubService.findAll(
                page, pageSize, splitRequestParameter(sortProperties), sortDirection
        );
    }
}
