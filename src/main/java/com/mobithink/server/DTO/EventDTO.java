package com.mobithink.server.DTO;

import com.mobithink.server.entity.Station;

/**
 * Created by athiel on 03/02/2017.
 */
public class EventDTO {

    private Long id;
    private String eventName;
    private Long startTime;
    private Long endTime;
    private PlaceDTO startPlace;
    private PlaceDTO endPlace;
    private StationDTO associatedStation;

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

    public StationDTO getAssociatedStation() {
        return associatedStation;
    }

    public void setAssociatedStation(StationDTO associatedStation) {
        this.associatedStation = associatedStation;
    }
}
