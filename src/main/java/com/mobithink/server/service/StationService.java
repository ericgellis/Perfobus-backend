package com.mobithink.server.service;

import com.mobithink.server.DTO.StationDTO;
import com.mobithink.server.entity.LineStationLink;
import com.mobithink.server.entity.Station;

import java.util.List;

/**
 * Created by athiel on 02/02/2017.
 */
public interface StationService {

    Station createStation (StationDTO stationDTO);

    LineStationLink createLineStationLink (LineStationLink lineStationLink);

    LineStationLink findByBusLineIdAndStationId (Long busLineId, Long stationId);

    Station findByName (String name);

    List<Station> findStationAssociatedWithBusLine(Long busLineId);
}
