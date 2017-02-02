package com.mobithink.server.facade;

import com.mobithink.server.entity.BusLine;
import com.mobithink.server.exeption.MobithinkBusinessException;
import com.mobithink.server.service.BusLineService;
import com.sun.activation.registries.MailcapParseException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by athiel on 02/02/2017.
 */

@RestController
@RequestMapping(value = "/mobithink/busline" )
public class BusLineFacade {

    @Resource
    private BusLineService busLineService;

    /**
     *
     * POST. Register a new busline.
     *
     * @param busLine object
     *
     * @return text : "success" if create bus line
     *          text : "exist" if line name exist
     *
     */

    @PostMapping(path = "/create", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@Valid @RequestBody BusLine busLine) throws MobithinkBusinessException{
        if(busLineService.findOneByName(busLine.getName()) == null){
            busLineService.createBusLine(busLine);
            return ResponseEntity.ok("succes");
        } return ResponseEntity.ok("exist");
    }

    /**
     *
     * GET. find busline list in a city.
     *
     * @param {cityName}
     *
     * @return List<BusLine> or null
     *
     *
     */


}
