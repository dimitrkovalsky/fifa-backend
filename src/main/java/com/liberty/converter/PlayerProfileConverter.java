package com.liberty.converter;

import com.liberty.dto.AttributeTO;
import com.liberty.dto.PlayerProfileTO;
import com.liberty.model.Attributes;
import com.liberty.model.PlayerProfile;
import com.liberty.rest.PlayerProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class PlayerProfileConverter {

    @Autowired
    private AttributeConverter attributeConverter;

    public Resource<PlayerProfileTO> convert(PlayerProfile playerProfile) {
        PlayerProfileTO playerProfileTO = new PlayerProfileTO();
        playerProfileTO.setId(playerProfile.getId());
        playerProfileTO.setRating(playerProfile.getRating());
        playerProfileTO.setName(playerProfile.getName());
        playerProfileTO.setFirstName(playerProfile.getFirstName());
        playerProfileTO.setLastName(playerProfile.getLastName());
        playerProfileTO.setCommonName(playerProfile.getCommonName());
        playerProfileTO.setPosition(playerProfile.getPosition());
        playerProfileTO.setLeagueId(playerProfile.getLeagueId());
        playerProfileTO.setNationId(playerProfile.getNationId());
        playerProfileTO.setClubId(playerProfile.getClubId());
        playerProfileTO.setPlayerType(playerProfile.getPlayerType());
        playerProfileTO.setQuality(playerProfile.getQuality());
        playerProfileTO.setColor(playerProfile.getColor());
        playerProfileTO.setAttributes(convertAttributes(playerProfile.getAttributes()));
        playerProfileTO.setHeadshotImgUrl(playerProfile.getHeadshotImgUrl());
        Resource<PlayerProfileTO> playerProfileTOResource = new Resource<>(playerProfileTO);
        playerProfileTOResource.add(linkTo(methodOn(PlayerProfileResource.class).get(playerProfile.getId())).withSelfRel());
        return playerProfileTOResource;
    }

    private List<AttributeTO> convertAttributes(List<Attributes> attributes) {
        return attributes.stream()
                .map(attribute -> attributeConverter.convert(attribute))
                .collect(toList());
    }
}
