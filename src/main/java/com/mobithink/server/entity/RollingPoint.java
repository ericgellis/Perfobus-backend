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

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place rollingPlace;

    @Column(name = "point_time")
    private Long timeOfRollingPoint;

    @Column(name = "traffic")
    private int traffic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getRollingPlace() {
        return rollingPlace;
    }

    public void setRollingPlace(Place rollingPlace) {
        this.rollingPlace = rollingPlace;
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
