package com.mobithink.server.entity;

import com.mobithink.server.DTO.PlaceDTO;

import javax.persistence.*;

/**
 * Created by athiel on 01/02/2017.
 */

@Entity
public class Trip {

    @Id
    @SequenceGenerator(name = "mobithink_uid", sequenceName = "mobithink_uid", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobithink_uid")
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String tripName;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTime;

    @Column(name = "atmo")
    private int atmo;

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "weather")
    private String weather;

    @Column(name = "vehicle_capacity")
    private int vehicleCapacity;

    @Column(name = "bus_line_name")
    private String busLineName;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "start_place_id")
    private Place startPlace;

    @ManyToOne
    @JoinColumn(name = "end_place_id")
    private Place endPlace;


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

    public Place getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(Place startPlace) {
        this.startPlace = startPlace;
    }

    public Place getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(Place endPlace) {
        this.endPlace = endPlace;
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(int vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public String getBusLineName() {
        return busLineName;
    }

    public void setBusLineName(String busLineName) {
        this.busLineName = busLineName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
