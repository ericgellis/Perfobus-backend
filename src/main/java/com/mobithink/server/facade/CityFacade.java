package com.mobithink.server.facade;

import com.mobithink.server.DTO.CityDTO;
import com.mobithink.server.DTO.ConverterOfDTO;
import com.mobithink.server.entity.City;
import com.mobithink.server.exeption.MobithinkBusinessException;
import com.mobithink.server.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by athiel on 31/01/2017.
 *
 */

@RestController
@RequestMapping(value = "/mobithink/city" )
public class CityFacade {

    private final Logger log = LoggerFactory.getLogger(CityFacade.class);

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
        List<CityDTO> cityDTOList = cityList.stream().map(ConverterOfDTO::convertCityToDTO).collect(Collectors.toList());
        log.info("find all city : size {}",cityDTOList.size());
        return ResponseEntity.ok(cityDTOList);
    }
}
