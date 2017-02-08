package com.mobithink.server.entity;

import javax.persistence.*;

/**
 * Created by athiel on 06/02/2017.
 *
 */

@Entity
public class Picture {

    @Id
    @SequenceGenerator(name = "mobithink_uid", sequenceName = "mobithink_uid", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobithink_uid")
    @Column(name="id")
    private Long id;

   @Column (name = "station_data_id")
    private Long stationDataId;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "picture_id")
    private Long pictureId;


    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStationDataId() {
        return stationDataId;
    }

    public void setStationDataId(Long stationDataId) {
        this.stationDataId = stationDataId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
