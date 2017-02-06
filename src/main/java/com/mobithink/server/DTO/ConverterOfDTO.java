package com.mobithink.server.DTO;

import com.mobithink.server.entity.*;

import java.util.List;

/**
 * Created by athiel on 02/02/2017.
 */
public class ConverterOfDTO {

    public static BusLineDTO convertBusLineToDTO(BusLine busLine){
        BusLineDTO busLineDTO = new BusLineDTO();
        busLineDTO.setId(busLine.getId());
        busLineDTO.setName(busLine.getName());
        busLineDTO.setDateOfCreation(busLine.getDateOfCreation());
        busLineDTO.setCityDto(convertCityToDTO(busLine.getCity()));

        return busLineDTO;
    }

    public static CityDTO convertCityToDTO(City city){
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());

        return cityDTO;
    }

    public static StationDTO convertStationToDTO(Station station){
        StationDTO stationDTO = new StationDTO();
        stationDTO.setId(station.getId());
        stationDTO.setStationName(station.getName());

        return stationDTO;
    }

    public static City convertCityDtoToCity (CityDTO cityDTO){
        City city = new City();
        if (cityDTO.getId() != null){
            city.setId(cityDTO.getId());
        }
        city.setName(cityDTO.getName());

        return city;
    }

    public static BusLine convertBusLineDtoToBusLine(BusLineDTO busLineDTO){
        BusLine busLine = new BusLine();
        if (busLineDTO.getId()!= null){
            busLine.setId(busLineDTO.getId());
        }
        busLine.setName(busLineDTO.getName());
        busLine.setDateOfCreation(busLineDTO.getDateOfCreation());
        busLine.setCity(convertCityDtoToCity(busLineDTO.getCityDto()));

        return busLine;
    }

    public static Station convertStationDtoToStation(StationDTO stationDTO){
        Station station = new Station();
        if (stationDTO.getId() != null){
            station.setId(stationDTO.getId());
        }
        station.setName(stationDTO.getStationName());

        return station;
    }

    public static TripDTO convertTripToTripDTO(Trip trip, List<StationDataDTO> stationDataDTOList, List<EventDTO> eventDTOList,
                                        List<RollingPointDTO> rollingPointDTOList){
        TripDTO tripDTO = new TripDTO(trip.getId(), trip.getTripName(),trip.getStartTime(),trip.getEndTime(),trip.getAtmo(),
                trip.getTemperature(),trip.getWeather(), trip.getVehicleCapacity(),trip.getBusLineName(), trip.getCityName(),
                stationDataDTOList, rollingPointDTOList, eventDTOList, trip.getStartGpsLat(), trip.getStartGpsLong(), trip.getEndGpsLat(),
                trip.getEndGpsLong() );

        return tripDTO;
    }

    public static StationDataDTO convertStationDataToDto(StationData stationData){
        StationDataDTO stationDataDTO = new StationDataDTO(stationData.getId(), stationData.getNumberOfComeIn(), stationData.getNumberOfGoOut(),
                stationData.getStartTime(),stationData.getEndTime(),stationData.getStationStep(), stationData.getStationName(), stationData.getGpsLat(),
                stationData.getGpsLong());
        return stationDataDTO;
    }

    public static EventDTO convertEventToDto(Event event){
        EventDTO eventDTO = new EventDTO(event.getId(),event.getEventName(),event.getStartTime(),event.getEndTime(), event.getGpsLat(),
                event.getGpsLong(), event.getStationData().getStationName());
        return eventDTO;
    }

    public static RollingPointDTO convretRollingPointToDto(RollingPoint rollingPoint){
        RollingPointDTO rollingPointDTO = new RollingPointDTO(rollingPoint.getId(), rollingPoint.getTimeOfRollingPoint(), rollingPoint.getGpsLat(),
                rollingPoint.getGpsLong(), rollingPoint.getTraffic());

        return rollingPointDTO;
    }
}
