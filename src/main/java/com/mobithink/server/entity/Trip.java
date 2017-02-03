package com.mobithink.server.entity;

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

    @Column(name = "direction")
    private String direction;

    @Column(name = "vehicle_capacity")
    private int vehicleCapacity;

    @ManyToOne
    @JoinColumn(name = "bus_line_id")
    private BusLine busLine;


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

    public BusLine getBusLine() {
        return busLine;
    }

    public void setBusLine(BusLine busLine) {
        this.busLine = busLine;
    }
}
