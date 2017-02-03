package com.mobithink.server.DTO;

/**
 * Created by athiel on 03/02/2017.
 */
public class RollingPointDTO {

    private Long startTime;
    private Long endTime;
    private PlaceDTO startPlace;
    private PlaceDTO endPlace;
    private int trafficIndex;

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

    public int getTrafficIndex() {
        return trafficIndex;
    }

    public void setTrafficIndex(int trafficIndex) {
        this.trafficIndex = trafficIndex;
    }
}
