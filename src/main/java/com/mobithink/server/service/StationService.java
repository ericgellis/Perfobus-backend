package com.mobithink.server.service;

import com.mobithink.server.entity.LineStationLink;
import com.mobithink.server.entity.Station;

import java.util.List;

/**
 * Created by athiel on 02/02/2017.
 */
public interface StationService {

    Station createStation (String name);

    List<LineStationLink> findLineStationLinkByLineId (Long id);

    LineStationLink createLineStationLink (LineStationLink lineStationLink);

    Station findByName (String name);
}
