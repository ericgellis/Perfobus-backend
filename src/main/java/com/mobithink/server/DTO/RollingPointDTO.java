package com.mobithink.server.DTO;

/**
 * Created by athiel on 03/02/2017.
 *
 */
public class RollingPointDTO {

    private Long id;
    private Long pointTime;
    private Long gpsLat;
    private Long gpsLong;
    private int trafficIndex;
    private Double speed;


    public RollingPointDTO() {
    }

    public RollingPointDTO(Long id, Long pointTime, Long gpsLat, Long gpsLong, int trafficIndex, Double speed) {
        this.id = id;
        this.pointTime = pointTime;
        this.gpsLat = gpsLat;
        this.gpsLong = gpsLong;
        this.trafficIndex = trafficIndex;
        this.speed = speed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
