package com.mobithink.server.DTO;

/**
 * Created by athiel on 03/02/2017.
 */
public class PlaceDTO {

    private Long id;
    private Long gpsLat;
    private Long gpsLong;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
