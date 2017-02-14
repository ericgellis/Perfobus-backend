package com.mobithink.server.entity;

import javax.persistence.*;

/**
 * Created by athiel on 01/02/2017.
 *
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

    @ManyToOne
    @JoinColumn(name = "bus_line_id")
    private BusLine busLine;

    @Column(name = "start_gps_lat")
    private Long startGpsLat;

    @Column(name = "start_gps_long")
    private Long startGpsLong;

    @Column(name = "end_gps_lat")
    private Long endGpsLat;

    @Column(name = "end_gps_long")
    private Long endGpsLong;


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

    public Long getStartGpsLat() {
        return startGpsLat;
    }

    public void setStartGpsLat(Long startGpsLat) {
        this.startGpsLat = startGpsLat;
    }

    public Long getStartGpsLong() {
        return startGpsLong;
    }

    public void setStartGpsLong(Long startGpsLong) {
        this.startGpsLong = startGpsLong;
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
