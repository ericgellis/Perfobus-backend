package com.mobithink.server.service;

import com.mobithink.server.entity.City;
import java.util.List;

/**
 * Created by athiel on 31/01/2017.
 *
 */

public interface CityService {

    City createCity (City city);

    City findOneCityById(Long id);

    List<City> findAllCity();

    City findOneByName(String name);

    City createOrLoadCity (City city);

}
