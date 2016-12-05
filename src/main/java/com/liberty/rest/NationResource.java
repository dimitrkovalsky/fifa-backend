package com.liberty.rest;

import com.liberty.model.Nation;
import com.liberty.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import static com.liberty.util.ControllerUtils.splitRequestParameter;

@RestController
@RequestMapping("/api/nations")
@CrossOrigin(origins = "*")
public class NationResource {

    @Autowired
    private NationService nationService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Nation findById(@PathVariable Long id) {
        return nationService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Nation> findAll(@RequestParam("page") Integer page,
                                @RequestParam("pageSize") Integer pageSize,
                                @RequestParam("sortProperties") String sortProperties,
                                @RequestParam("sortDirection") Sort.Direction sortDirection) {
        return nationService.findAll(
                page, pageSize, splitRequestParameter(sortProperties), sortDirection
        );
    }
}
