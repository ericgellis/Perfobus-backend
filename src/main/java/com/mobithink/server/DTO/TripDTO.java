package com.mobithink.server.DTO;

import java.util.List;

/**
 * Created by athiel on 03/02/2017.
 *
 */
public class TripDTO {

    private Long id;
    private String tripName;
    private Long startTime;
    private Long endTime;
    private int atmo;
    private int temperature;
    private String weather;
    private int vehicleCapacity;
    private Long busLineid;
    private List<StationDataDTO> stationDataDTOList;
    private List<RollingPointDTO> rollingPointDTOList;
    private List<EventDTO> eventDTOList;
    private Long startGpsLat;
    private Long StartGpsLong;
    private Long endGpsLat;
    private Long endGpsLong;

    public TripDTO() {
    }
 
	public TripDTO(Long id, String tripName, Long startTime, Long endTime, int atmo, int temperature, String weather,
                   int vehicleCapacity, Long busLineid, List<StationDataDTO> stationDataDTOList,
                   List<RollingPointDTO> rollingPointDTOList, List<EventDTO> eventDTOList, Long startGpsLat, Long startGpsLong,
                   Long endGpsLat, Long endGpsLong) {
		super();
		this.id = id;
		this.tripName = tripName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.atmo = atmo;
		this.temperature = temperature;
		this.weather = weather;
		this.vehicleCapacity = vehicleCapacity;
		this.busLineid = busLineid;
		this.stationDataDTOList = stationDataDTOList;
		this.rollingPointDTOList = rollingPointDTOList;
		this.eventDTOList = eventDTOList;
		this.startGpsLat = startGpsLat;
		StartGpsLong = startGpsLong;
		this.endGpsLat = endGpsLat;
		this.endGpsLong = endGpsLong;
	}


	public Long getBusLineid() {
		return busLineid;
	}


	public void setBusLineid(Long busLineid) {
		this.busLineid = busLineid;
	}




	public Long getStartGpsLat() {
        return startGpsLat;
    }

    public void setStartGpsLat(Long startGpsLat) {
        this.startGpsLat = startGpsLat;
    }

    public Long getStartGpsLong() {
        return StartGpsLong;
    }

    public void setStartGpsLong(Long startGpsLong) {
        StartGpsLong = startGpsLong;
    }

    public Long getEndGpsLat() {
        return endGpsLat;
    }

    public void setEndGpsLat(Long endGpsLat) {
        this.endGpsLat = endGpsLat;
    }

    public Long getEndGpsLong() {
        return endGpsLong;
    }

    public void setEndGpsLong(Long endGpsLong) {
        this.endGpsLong = endGpsLong;
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

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(int vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public List<StationDataDTO> getStationDataDTOList() {
        return stationDataDTOList;
    }

    public void setStationDataDTOList(List<StationDataDTO> stationDataDTOList) {
        this.stationDataDTOList = stationDataDTOList;
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
