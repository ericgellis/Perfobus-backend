package com.mobithink.server.service.impl;

import com.mobithink.server.dao.CityRepository;
import com.mobithink.server.entity.City;
import com.mobithink.server.service.CityService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by athiel on 31/01/2017.
 */

@Component()
@Transactional
public class CityServiceImpl implements CityService {

    @Resource
    private CityRepository cityRepository;

    @Override
    public City createCity(String name) {
        City newCity = new City();
        newCity.setCityName(name);
        return cityRepository.save(newCity);
    }

    @Override
    public City findOneCityById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public List<City> findAllCity() {
        List<City> cityList = new ArrayList<>();
        Iterable<City> cityIterable = cityRepository.findAll();

        if(cityIterable != null) {
            for (City city : cityIterable) {
                cityList.add(city);
            }
            return cityList;
        }else return null;
    }
}
