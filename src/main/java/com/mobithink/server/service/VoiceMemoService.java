package com.mobithink.server.service;

import com.mobithink.server.entity.VoiceMemo;

import java.util.List;

/**
 * Created by mplaton on 29/03/2017.
 */
public interface VoiceMemoService {

    VoiceMemo savedVoiceMemo (VoiceMemo voiceMemo);

    List<VoiceMemo> findByEventId (Long eventId);

}
