package com.mobithink.server.facade;

import com.mobithink.server.DTO.ConverterOfDTO;
import com.mobithink.server.DTO.StationDTO;
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
 *
 */

@RestController
@RequestMapping(value = "/mobithink/station" )
public class StationFacade {

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
    @GetMapping(path = "/find/{lineIdString}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<List<StationDTO>> createCity (@Valid @PathVariable String lineIdString) throws MobithinkBusinessException {
        Long lineId = Long.parseLong(lineIdString);
        List<Station> stationList = stationService.findStationAssociatedWithBusLine(lineId);
        if (stationList != null){
            List<StationDTO> stationDTOList = new ArrayList<>();
            for (Station station : stationList){
                LineStationLink lineStationLink = stationService.findByBusLineIdAndStationId(lineId, station.getId());
                int step = lineStationLink.getStep();
                stationDTOList.add(ConverterOfDTO.convertStationToDTO(station, step));
            }return ResponseEntity.ok(stationDTOList);
        }else return null;
    }
}
