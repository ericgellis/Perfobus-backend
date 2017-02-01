package com.mobithink.server.service;

import com.mobithink.server.DTO.CityDTO;
import com.mobithink.server.entity.City;

import java.util.List;

/**
 * Created by athiel on 31/01/2017.
 */
public interface CityService {

    City createCity (String name);

    City findOneCityById(Long id);

    List<CityDTO> findAllCity();

}
