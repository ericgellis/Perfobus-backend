package com.mobithink.server.dao;

import com.mobithink.server.entity.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by athiel on 03/02/2017.
 */
public interface TripRepository extends CrudRepository<Trip, Long> {

    List<Trip> findByBusLineNameAndCityName(String busLineName, String ciyName);
}
