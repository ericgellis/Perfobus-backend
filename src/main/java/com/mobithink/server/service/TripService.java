package com.mobithink.server.service;

import com.mobithink.server.entity.Trip;
import java.util.List;

/**
 * Created by athiel on 03/02/2017.
 *
 */
public interface TripService {

    Trip createTrip(Trip trip);

    List<Trip> findTripListByBusLineNameAndcityName (String busLineName, String cityName);
}
