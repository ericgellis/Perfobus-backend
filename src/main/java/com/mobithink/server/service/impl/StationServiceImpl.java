package com.mobithink.server.service.impl;

import com.mobithink.server.dao.LineStationLinkRepository;
import com.mobithink.server.dao.StationRepository;
import com.mobithink.server.entity.LineStationLink;
import com.mobithink.server.entity.Station;
import com.mobithink.server.service.StationService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by athiel on 02/02/2017.
 */

@Component()
@Transactional
public class StationServiceImpl implements StationService{

    @Resource
    LineStationLinkRepository lineStationLinkRepository;

    @Resource
    StationRepository stationRepository;

    @Override
    public Station createStation(String name)
    {
        Station station = new Station();
        station.setName(name);
        return stationRepository.save(station);
    }

    @Override
    public LineStationLink createLineStationLink(LineStationLink lineStationLink) {
        return lineStationLinkRepository.save(lineStationLink);
    }

    @Override
    public Station findByName(String name) {
        return stationRepository.findByName(name);
    }

    @Override
    public List<Station> findStationAssociatedWithBusLine(Long busLineId) {
        List<LineStationLink> lineStationLinkList = lineStationLinkRepository.findByBusLineId(busLineId);
        if (lineStationLinkList != null){
            List<Station> stationList = new ArrayList<>();
            for (LineStationLink lineStationLink : lineStationLinkList){
                stationList.add(lineStationLink.getStation());
            }
            return stationList;
        }else return null;
    }
}
