package com.mobithink.server.facade;

import com.mobithink.server.DTO.BusLineDTO;
import com.mobithink.server.DTO.CityDTO;
import com.mobithink.server.DTO.ConverterOfDTO;
import com.mobithink.server.DTO.StationDTO;
import com.mobithink.server.entity.BusLine;
import com.mobithink.server.entity.City;
import com.mobithink.server.entity.LineStationLink;
import com.mobithink.server.entity.Station;
import com.mobithink.server.exeption.MobithinkBusinessException;
import com.mobithink.server.service.StationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by athiel on 02/02/2017.
 */

@RestController
@RequestMapping(value = "/mobithink/station" )
public class StationFacade {

    ConverterOfDTO converterOfDTO = new ConverterOfDTO();

    @Resource
    StationService stationService;

    /**
     *
     * GET. find station of line.
     *
     * @param "line_id"
     *
     * @return list<StationDTO> or null
     *
     */
    @GetMapping(path = "/find/{line_id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<List<StationDTO>> createCity (@Valid @PathVariable Long lineId) throws MobithinkBusinessException {

        List<LineStationLink> lineStationLinks = stationService.findLineStationLinkByLineId(lineId);
        if (lineStationLinks != null){
            List<StationDTO> stationDTOList = new ArrayList<>();
            for (LineStationLink lineStationLink : lineStationLinks){
                stationDTOList.add(converterOfDTO.convertStationToDTO(lineStationLink.getStation()));
            }
            return ResponseEntity.ok(stationDTOList);
        }
        return null;
    }
}