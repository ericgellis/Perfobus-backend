package com.mobithink.server.dao;

import com.mobithink.server.entity.VoiceMemo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mplaton on 29/03/2017.
 */
public interface VoiceMemoRepository extends CrudRepository<VoiceMemo, Long> {

    List<VoiceMemo> findByEventId (Long eventId);

}
