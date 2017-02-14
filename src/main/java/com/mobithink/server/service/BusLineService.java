package com.mobithink.server.service;

import com.mobithink.server.entity.BusLine;
import com.mobithink.server.entity.LineStationLink;

import java.util.List;

/**
 * Created by athiel on 02/02/2017.
 *
 */

public interface BusLineService {

    BusLine createBusLine(BusLine busLine);

    List<BusLine> findByCityId(Long id);

    BusLine findOneByName(String name);

    BusLine findByNameAndCityId(String name, Long cityId);
    
    List<LineStationLink> findLineStationLinkByBusLineId(Long id);
    
    void deleteLineStationLinkById(Long id);
}
