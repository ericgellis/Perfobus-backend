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
    public City createCity(City city) {
        return cityRepository.save(city);
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

    @Override
    public City findOneByName(String name) {
        return cityRepository.findOneByName(name);
    }

    @Override
    public City createOrLoadCity(City city) {
        City savedCity = cityRepository.findOneByName(city.getName());
        if (savedCity == null){
            savedCity = cityRepository.save(city);
        }
        return savedCity ;
    }
}
