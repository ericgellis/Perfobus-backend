package com.mobithink.server.dao;

import com.mobithink.server.entity.BusLine;
import com.mobithink.server.entity.City;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by athiel on 31/01/2017.
 */
public interface CityRepository extends CrudRepository<City, Long> {
    City findOneByName(String name);
}
