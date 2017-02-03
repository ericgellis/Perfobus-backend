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
    private PlaceDTO place;
    private String associatedStationDtoName;

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

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(PlaceDTO place) {
        this.place = place;
    }

    public String getAssociatedStationDtoName() {
        return associatedStationDtoName;
    }

    public void setAssociatedStationDtoName(String associatedStationDtoName) {
        this.associatedStationDtoName = associatedStationDtoName;
    }
}
