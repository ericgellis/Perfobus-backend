package com.mobithink.server.DTO;

import com.mobithink.server.entity.RollingPoint;

import java.util.List;

/**
 * Created by athiel on 03/02/2017.
 */
public class TripDTO {

    private Long id;
    private String tripName;
    private Long startTime;
    private Long endTime;
    private int atmo;
    private int temperature;
    private String weather;
    private String direction;
    private int vehicleCapacity;
    private String associatedBusLineName;
    private String associatedCityName;
    private List<StationDTO> stationDTOList;
    private List<RollingPointDTO> rollingPointDTOList;
    private List<EventDTO> eventDTOList;
    private PlaceDTO startPlace;
    private PlaceDTO endPlace;

    public PlaceDTO getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(PlaceDTO startPlace) {
        this.startPlace = startPlace;
    }

    public PlaceDTO getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(PlaceDTO endPlace) {
        this.endPlace = endPlace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public int getAtmo() {
        return atmo;
    }

    public void setAtmo(int atmo) {
        this.atmo = atmo;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(int vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public String getAssociatedBusLineName() {
        return associatedBusLineName;
    }

    public void setAssociatedBusLineName(String associatedBusLineName) {
        this.associatedBusLineName = associatedBusLineName;
    }

    public String getAssociatedCityName() {
        return associatedCityName;
    }

    public void setAssociatedCityName(String associatedCityName) {
        this.associatedCityName = associatedCityName;
    }

    public List<StationDTO> getStationDTOList() {
        return stationDTOList;
    }

    public void setStationDTOList(List<StationDTO> stationDTOList) {
        this.stationDTOList = stationDTOList;
    }

    public List<RollingPointDTO> getRollingPointDTOList() {
        return rollingPointDTOList;
    }

    public void setRollingPointDTOList(List<RollingPointDTO> rollingPointDTOList) {
        this.rollingPointDTOList = rollingPointDTOList;
    }

    public List<EventDTO> getEventDTOList() {
        return eventDTOList;
    }

    public void setEventDTOList(List<EventDTO> eventDTOList) {
        this.eventDTOList = eventDTOList;
    }
}
