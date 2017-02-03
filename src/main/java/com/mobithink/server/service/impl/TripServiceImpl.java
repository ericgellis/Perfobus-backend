package com.mobithink.server.service.impl;

import com.mobithink.server.dao.TripRepository;
import com.mobithink.server.entity.Trip;
import com.mobithink.server.service.TripService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by athiel on 03/02/2017.
 */

@Component()
@Transactional
public class TripServiceImpl implements TripService {

    @Resource
    TripRepository tripRepository;

    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }
}
