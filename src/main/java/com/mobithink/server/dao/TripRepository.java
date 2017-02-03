package com.mobithink.server.dao;

import com.mobithink.server.entity.Trip;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by athiel on 03/02/2017.
 */
public interface TripRepository extends CrudRepository<Trip, Long> {

}
