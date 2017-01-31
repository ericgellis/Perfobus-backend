package com.mobithink.server.service;

import com.mobithink.server.entity.City;

/**
 * Created by athiel on 31/01/2017.
 */
public interface CityService {

    City createCity (String name);

    City findOneCityById(Long id);

    Iterable<City> findAllCity();

}
