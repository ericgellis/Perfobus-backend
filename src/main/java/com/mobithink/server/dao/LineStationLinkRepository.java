package com.mobithink.server.dao;

import com.mobithink.server.entity.LineStationLink;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by athiel on 02/02/2017.
 *
 */
public interface LineStationLinkRepository extends CrudRepository<LineStationLink, Long> {

    List<LineStationLink> findByBusLineId(Long id);

    LineStationLink findByBusLineIdAndStationId (Long busLineId, Long stationId);
}
