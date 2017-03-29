package com.mobithink.server.entity;

import javax.persistence.*;

/**
 * Created by mplaton on 29/03/2017.
 */

@Entity
public class VoiceMemo {

    @Id
    @SequenceGenerator(name = "mobithink_uid", sequenceName = "mobithink_uid", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobithink_uid")
    @Column(name="id")
    private Long id;

    @Column (name = "voice_memo_id")
    private Long voiceMemoId;

    @Column(name = "voice_memo_name")
    private String voiceMemoName;

    @Column(name = "event_id")
    private Long eventId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVoiceMemoId() {
        return voiceMemoId;
    }

    public void setVoiceMemoId(Long voiceMemoId) {
        this.voiceMemoId = voiceMemoId;
    }

    public String getVoiceMemoName() {
        return voiceMemoName;
    }

    public void setVoiceMemoName(String voiceMemoName) {
        this.voiceMemoName = voiceMemoName;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
