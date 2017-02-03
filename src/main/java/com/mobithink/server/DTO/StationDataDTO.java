package com.mobithink.server.DTO;

/**
 * Created by athiel on 03/02/2017.
 */
public class StationDataDTO {

    private Long id;
    private int numberOfComeIn;
    private int numberOfGoOut;
    private Long startTime;
    private Long endTime;
    private Long stationStep;
    private String stationName;
    private PlaceDTO placeDTO;

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

    public Long getStationStep() {
        return stationStep;
    }

    public void setStationStep(Long stationStep) {
        this.stationStep = stationStep;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public PlaceDTO getPlaceDTO() {
        return placeDTO;
    }

    public void setPlaceDTO(PlaceDTO placeDTO) {
        this.placeDTO = placeDTO;
    }
}
