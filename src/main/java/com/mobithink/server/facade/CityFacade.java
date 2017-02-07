package com.mobithink.server.facade;

import com.mobithink.server.DTO.CityDTO;
import com.mobithink.server.DTO.ConverterOfDTO;
import com.mobithink.server.entity.City;
import com.mobithink.server.exeption.MobithinkBusinessException;
import com.mobithink.server.service.CityService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by athiel on 31/01/2017.
 */

@RestController
@RequestMapping(value = "/mobithink/city" )
public class CityFacade {

    @Resource
    private CityService cityService;


    /**
     *
     * GET. find all cities.
     *
     *
     * @return  List<CityDTO> or null
     *
     *
     */
    @GetMapping(path = "/findAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<List<CityDTO>> findAllCity() throws MobithinkBusinessException {
        List<City> cityList = cityService.findAllCity();
        List<CityDTO> cityDTOList = new ArrayList<>();
        if (cityList != null){
            for(City city : cityList){
                cityDTOList.add(ConverterOfDTO.convertCityToDTO(city));
            }
            return ResponseEntity.ok(cityDTOList);
        } else return null;
    }
}
