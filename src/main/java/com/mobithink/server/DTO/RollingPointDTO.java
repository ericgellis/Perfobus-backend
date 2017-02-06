package com.mobithink.server.DTO;

/**
 * Created by athiel on 03/02/2017.
 */
public class RollingPointDTO {

    private Long pointTime;
    private Long gpsLat;
    private Long gpsLong;
    private int trafficIndex;

    public Long getPointTime() {
        return pointTime;
    }

    public void setPointTime(Long pointTime) {
        this.pointTime = pointTime;
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

    public int getTrafficIndex() {
        return trafficIndex;
    }

    public void setTrafficIndex(int trafficIndex) {
        this.trafficIndex = trafficIndex;
    }
}
