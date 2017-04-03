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
    private Long gpsLat;

    @Column(name = "gps_long")
    private Long gpsLong;

    @Column(name = "gps_endlat")
    private Long gpsEndLat;

    @Column(name = "gps_endlong")
    private Long gpsEndLong;

    @Column(name = "voice_memo")
    private String voice_memo;

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

    public Long getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(Long gpsLat) {
        this.gpsLat = gpsLat;
    }

    public Long getGpsLong() {
        return gpsLong;
    }

    public void setGpsLong(Long gpsLong) {
        this.gpsLong = gpsLong;
    }

    public StationData getStationData() {
        return stationData;
    }

    public void setStationData(StationData stationData) {
        this.stationData = stationData;
    }

    public Long getGpsEndLat()  {return gpsEndLat; }

    public void setGpsEndLat(Long gpsEndLat) { this.gpsEndLat = gpsEndLat; }

    public Long getGpsEndLong() { return gpsEndLong; }

    public void setGpsEndLong(Long gpsEndLong) { this.gpsEndLong = gpsEndLong; }

    public Long getTimeSaving() { return timeSaving; }

    public void setTimeSaving(Long timeSaving) { this.timeSaving = timeSaving; }

    public String getVoice_memo() {
        return voice_memo;
    }

    public void setVoice_memo(String voice_memo) {
        this.voice_memo = voice_memo;
    }
}
