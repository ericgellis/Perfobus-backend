package com.mobithink.server.facade;

import com.mobithink.server.entity.City;
import com.mobithink.server.service.CityService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by athiel on 31/01/2017.
 */

@RestController
@RequestMapping(value = "/mobithink/city" )
public class CityFacade {

    @Resource
    private CityService cityService;

    @GetMapping(path = "/create/{cityName}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> createCity (@Valid @PathVariable String cityName){
        City savedCity = cityService.createCity(cityName);

        if (savedCity.getId() == null){
            return ResponseEntity.ok("error");
        }
        return ResponseEntity.ok("success");
    }

    @GetMapping(path = "/findAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<List<City>> createCity (){
        return ResponseEntity.ok(cityService.findAllCity());
    }
}
