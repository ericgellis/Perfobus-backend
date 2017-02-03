package com.mobithink.server.facade;

import com.mobithink.server.DTO.BusLineDTO;
import com.mobithink.server.DTO.ConverterOfDTO;
import com.mobithink.server.DTO.StationDTO;
import com.mobithink.server.entity.BusLine;
import com.mobithink.server.entity.City;
import com.mobithink.server.entity.LineStationLink;
import com.mobithink.server.entity.Station;
import com.mobithink.server.exeption.MobithinkBusinessException;
import com.mobithink.server.service.BusLineService;
import com.mobithink.server.service.CityService;
import com.mobithink.server.service.StationService;
import com.sun.activation.registries.MailcapParseException;
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
@RequestMapping(value = "/mobithink/busline" )
public class BusLineFacade {

    ConverterOfDTO converterOfDTO = new ConverterOfDTO();

    @Resource
    private BusLineService busLineService;

    @Resource
    private CityService cityService;

    @Resource
    private StationService stationService;


    /**
     *
     * POST. Register a new busline.
     *
     * @param busLineDto object
     *
     * @return text : "success" if create bus line
     *          text : "exist" if association BusLine and City exist
     *
     */
    @PostMapping(path = "/create", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@Valid @RequestBody BusLineDTO busLineDto) throws MobithinkBusinessException{

        BusLine searchedBusLine = busLineService.findByNameAndCityId(busLineDto.getName(), busLineDto.getCityDto().getId());

        if ( searchedBusLine != null){
            return ResponseEntity.ok("exist");
        } else {
            List<Station> stationList = savedStationDTO(busLineDto.getStationDTOList());
            City savedCity = savedCity(converterOfDTO.convertCityDtoToCity(busLineDto.getCityDto()));
            BusLine savedBusLine = saveNewBusLine(busLineDto, savedCity);
            savelineStationLink(savedBusLine, stationList);
            return ResponseEntity.ok("success");
        }
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
    @GetMapping(path = "/find/{cityName}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<List<BusLineDTO>> findAllByCity(@Valid @PathVariable String cityName) throws MobithinkBusinessException {
        City city = cityService.findOneByName(cityName);
        if (city != null){
            List<BusLine> busLineIterable = busLineService.findByCityId(city.getId());
            if (busLineIterable != null) {
                List<BusLineDTO> busLineDTOList = new ArrayList<>();
                for (BusLine busLine : busLineIterable) {
                    busLineDTOList.add(converterOfDTO.convertBusLineToDTO(busLine));
                }
                return ResponseEntity.ok(busLineDTOList);
            } else return null;
        } else return null;
    }

    private BusLine saveNewBusLine(BusLineDTO busLineDto, City city){
        BusLine busLine = converterOfDTO.convertBusLineDtoToBusLine(busLineDto);
        busLine.setCity(city);
       return busLineService.createBusLine(busLine);
    }

    private City savedCity(City city){
            return cityService.createCity(city);
    }

    private void savelineStationLink(BusLine savedBusLine, List<Station> stationList){

        for (Station station : stationList){
            LineStationLink lineStationLink = new LineStationLink();
            lineStationLink.setBusLine(savedBusLine);
            lineStationLink.setStation(station);
            stationService.createLineStationLink(lineStationLink);
        }
    }

    private List<Station> savedStationDTO(List<StationDTO> stationDTOList) {
        List<Station> stationList = new ArrayList<>();
        for (StationDTO stationDTO : stationDTOList){
            Station station = stationService.findByName(stationDTO.getStationName());
            if (station == null){
                station = stationService.createStation(stationDTO.getStationName());
            }
           stationList.add(station);
        }
        return stationList;
    }

}
