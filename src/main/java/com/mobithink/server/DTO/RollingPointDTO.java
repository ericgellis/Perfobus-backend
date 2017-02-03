package com.mobithink.server.DTO;

/**
 * Created by athiel on 03/02/2017.
 */
public class RollingPointDTO {

    private Long pointTime;
    private PlaceDTO placeDTO;
    private int trafficIndex;

    public Long getPointTime() {
        return pointTime;
    }

    public void setPointTime(Long pointTime) {
        this.pointTime = pointTime;
    }

    public PlaceDTO getPlaceDTO() {
        return placeDTO;
    }

    public void setPlaceDTO(PlaceDTO placeDTO) {
        this.placeDTO = placeDTO;
    }

    public int getTrafficIndex() {
        return trafficIndex;
    }

    public void setTrafficIndex(int trafficIndex) {
        this.trafficIndex = trafficIndex;
    }
}
