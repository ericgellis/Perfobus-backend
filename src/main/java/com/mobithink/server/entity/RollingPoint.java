package com.mobithink.server.entity;

import javax.persistence.*;

/**
 * Created by athiel on 01/02/2017.
 */

@Entity
public class RollingPoint {

    @Id
    @SequenceGenerator(name = "mobithink_uid", sequenceName = "mobithink_uid", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobithink_uid")
    @Column(name="id")
    private Long id;

    @Column(name = "gps_lat")
    private Long gpsLat;

    @Column(name = "gps_long")
    private Long gpsLong;

    @Column(name = "point_time")
    private Long timeOfRollingPoint;

    @Column(name = "traffic")
    private int traffic;

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

    public Long getTimeOfRollingPoint() {
        return timeOfRollingPoint;
    }

    public void setTimeOfRollingPoint(Long timeOfRollingPoint) {
        this.timeOfRollingPoint = timeOfRollingPoint;
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }
}
