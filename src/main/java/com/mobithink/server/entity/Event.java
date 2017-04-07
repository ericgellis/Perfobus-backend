package com.mobithink.server.entity;

import javax.persistence.*;

/**
 * Created by athiel on 01/02/2017.
 *
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

    @Column(name = "gps_lat")
    private Double gpsLat;

    @Column(name = "gps_long")
    private Double gpsLong;

    @Column(name = "gps_endlat")
    private Double gpsEndLat;

    @Column(name = "gps_endlong")
    private Double gpsEndLong;

    @Column(name = "voice_memo")
    private String voiceMemo;

    @Column(name = "picture")
    private String picture;

    @Column(name = "time_saving")
    private Long timeSaving;

    @ManyToOne
    @JoinColumn(name = "station_data_id")
    private StationData stationData;

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

    public Double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(Double gpsLat) {
        this.gpsLat = gpsLat;
    }

    public Double getGpsLong() {
        return gpsLong;
    }

    public void setGpsLong(Double gpsLong) {
        this.gpsLong = gpsLong;
    }

    public StationData getStationData() {
        return stationData;
    }

    public void setStationData(StationData stationData) {
        this.stationData = stationData;
    }

    public Double getGpsEndLat()  {return gpsEndLat; }

    public void setGpsEndLat(Double gpsEndLat) { this.gpsEndLat = gpsEndLat; }

    public Double getGpsEndLong() { return gpsEndLong; }

    public void setGpsEndLong(Double gpsEndLong) { this.gpsEndLong = gpsEndLong; }

    public Long getTimeSaving() { return timeSaving; }

    public void setTimeSaving(Long timeSaving) { this.timeSaving = timeSaving; }

    public String getVoiceMemo() {
        return voiceMemo;
    }

    public void setVoiceMemo(String voiceMemo) {
        this.voiceMemo = voiceMemo;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
