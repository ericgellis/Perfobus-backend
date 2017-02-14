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

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value = "/mobithink/busline" )
public class BusLineFacade {

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
     * @return status 201 if create bus line
     *          status 406 (and message) if association BusLine and City exist
     *
     */
    @PostMapping(path = "/create", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<Void> create(@Valid @RequestBody BusLineDTO busLineDto) throws MobithinkBusinessException{

    	City savedCity = new City();

    	if (busLineDto.getCityDto() != null){

    		if(busLineDto.getCityDto().getId() != null){
    			
    			savedCity = cityService.findOneCityById(busLineDto.getCityDto().getId());

    		} else {

    			savedCity = cityService.findOneByName(busLineDto.getCityDto().getName());
    			
    			if (savedCity == null){
    				savedCity = cityService.createCity(ConverterOfDTO.convertCityDtoToCity(busLineDto.getCityDto()));
    			}
    		}
    	}

    	BusLine searchedBusLine = busLineService.findByNameAndCityId(busLineDto.getName(), savedCity.getId());

    	if ( searchedBusLine != null){

    		HttpHeaders httpHeaders = new HttpHeaders();
    		httpHeaders.set("message", "Ligne existante");
    		return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_ACCEPTABLE);
    		
    	} else {

    		BusLine savedBusLine = saveNewBusLine(busLineDto, savedCity);
    		savedStationDTO(busLineDto.getStationDTOList(), savedBusLine);
    		return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.CREATED);
    		
    	}
    }
    
    /**
    *
    * POST. Update busline.
    *
    * @param busLineDto object
    *
    * @return status 201 if Update bus line
    *         
    *
    */
   @PostMapping(path = "/update", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
   public ResponseEntity<Void> update(@Valid @RequestBody BusLineDTO busLineDto) throws MobithinkBusinessException{

   	List<LineStationLink> oldLineStationLinkList = busLineService.findLineStationLinkByBusLineId(busLineDto.getId());
   	for (LineStationLink lineStationLink : oldLineStationLinkList){
   		busLineService.deleteLineStationLinkById(lineStationLink.getId());
   	}
   	
   	BusLine updateBusLine = ConverterOfDTO.convertBusLineDtoToBusLine(busLineDto);
   	
   	savedStationDTO(busLineDto.getStationDTOList(), updateBusLine);

   	return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.CREATED);
   
   }




    /**
     *
     * GET. find busline list in a city.
     *
     * @param cityName
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
                    busLineDTOList.add(ConverterOfDTO.convertBusLineToDTO(busLine));
                }
                return ResponseEntity.ok(busLineDTOList);
            } else return null;
        } else return null;
    }

    private BusLine saveNewBusLine(BusLineDTO busLineDto, City city){
        BusLine busLine = ConverterOfDTO.convertBusLineDtoToBusLine(busLineDto);
        busLine.setCity(city);
        return busLineService.createBusLine(busLine);
    }

    private void savelineStationLink(BusLine savedBusLine, Station station, int step){

            LineStationLink lineStationLink = new LineStationLink();
            lineStationLink.setBusLine(savedBusLine);
            lineStationLink.setStation(station);
            lineStationLink.setStep(step);
            stationService.createLineStationLink(lineStationLink);
    }

    private void savedStationDTO(List<StationDTO> stationDTOList, BusLine savedBusLine) {

        for (StationDTO stationDTO : stationDTOList){
            Station station = stationService.findByName(stationDTO.getStationName());
            if (station == null){
                station = stationService.createStation(stationDTO);
            }
            savelineStationLink(savedBusLine, station, stationDTO.getStep());
        }
    }
}
