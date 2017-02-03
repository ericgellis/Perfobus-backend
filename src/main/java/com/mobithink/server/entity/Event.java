package com.mobithink.server.entity;

import javax.persistence.*;

/**
 * Created by athiel on 01/02/2017.
 */

@Entity
public class Event {

    @Id
    @SequenceGenerator(name = "mobithink_uid", sequenceName = "mobithink_uid", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobithink_uid")
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String eventName;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTime;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "station_data_id")
    private StationData associatedStationData;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;


    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public StationData getAssociatedStationData() {
        return associatedStationData;
    }

    public void setAssociatedStationData(StationData associatedStationData) {
        this.associatedStationData = associatedStationData;
    }
}
