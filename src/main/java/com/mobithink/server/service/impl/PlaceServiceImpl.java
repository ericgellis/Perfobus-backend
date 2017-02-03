package com.mobithink.server.service.impl;

import com.mobithink.server.dao.PlaceRepository;
import com.mobithink.server.entity.Place;
import com.mobithink.server.service.PlaceService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by athiel on 03/02/2017.
 */
@Component()
@Transactional
public class PlaceServiceImpl implements PlaceService{

    @Resource
    PlaceRepository placeRepository;


    @Override
    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }
}
