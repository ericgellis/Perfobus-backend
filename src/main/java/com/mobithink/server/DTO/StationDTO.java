package com.mobithink.server.DTO;

/**
 * Created by athiel on 02/02/2017.
 */
public class StationDTO {

    private Long id;
    private String stationName;
    private int step;

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
