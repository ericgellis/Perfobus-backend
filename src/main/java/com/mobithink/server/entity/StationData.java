package com.mobithink.server.entity;

import javax.persistence.*;

/**
 * Created by athiel on 01/02/2017.
 */

@Entity
public class StationData {

    @Id
    @SequenceGenerator(name = "mobithink_uid", sequenceName = "mobithink_uid", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobithink_uid")
    @Column(name="id")
    private Long id;

    @Column(name = "come_in")
    private int numberOfComeIn;

    @Column(name = "go_out")
    private int numberOfGoOut;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTime;

    @Column(name = "step")
    private int stationStep;

    @Column(name = "station_name")
    private String stationName;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfComeIn() {
        return numberOfComeIn;
    }

    public void setNumberOfComeIn(int numberOfComeIn) {
        this.numberOfComeIn = numberOfComeIn;
    }

    public int getNumberOfGoOut() {
        return numberOfGoOut;
    }

    public void setNumberOfGoOut(int numberOfGoOut) {
        this.numberOfGoOut = numberOfGoOut;
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

    public int getStationStep() {
        return stationStep;
    }

    public void setStationStep(int stationStep) {
        this.stationStep = stationStep;
    }
}
