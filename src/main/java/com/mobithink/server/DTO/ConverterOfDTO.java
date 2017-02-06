package com.mobithink.server.DTO;

import com.mobithink.server.entity.BusLine;
import com.mobithink.server.entity.City;
import com.mobithink.server.entity.Station;

/**
 * Created by athiel on 02/02/2017.
 */
public class ConverterOfDTO {

    public BusLineDTO convertBusLineToDTO(BusLine busLine){
        BusLineDTO busLineDTO = new BusLineDTO();
        busLineDTO.setId(busLine.getId());
        busLineDTO.setName(busLine.getName());
        busLineDTO.setDateOfCreation(busLine.getDateOfCreation());
        busLineDTO.setCityDto(convertCityToDTO(busLine.getCity()));

        return busLineDTO;
    }

    public CityDTO convertCityToDTO(City city){
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());

        return cityDTO;
    }

    public StationDTO convertStationToDTO(Station station){
        StationDTO stationDTO = new StationDTO();
        stationDTO.setId(station.getId());
        stationDTO.setStationName(station.getName());

        return stationDTO;
    }

    public City convertCityDtoToCity (CityDTO cityDTO){
        City city = new City();
        if (cityDTO.getId() != null){
            city.setId(cityDTO.getId());
        }
        city.setName(cityDTO.getName());

        return city;
    }

    public BusLine convertBusLineDtoToBusLine(BusLineDTO busLineDTO){
        BusLine busLine = new BusLine();
        if (busLineDTO.getId()!= null){
            busLine.setId(busLineDTO.getId());
        }
        busLine.setName(busLineDTO.getName());
        busLine.setDateOfCreation(busLineDTO.getDateOfCreation());
        busLine.setCity(convertCityDtoToCity(busLineDTO.getCityDto()));

        return busLine;
    }

    public Station convertStationDtoToStation(StationDTO stationDTO){
        Station station = new Station();
        if (stationDTO.getId() != null){
            station.setId(stationDTO.getId());
        }
        station.setName(stationDTO.getStationName());

        return station;
    }


}
