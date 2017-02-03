package com.mobithink.server.service.impl;

import com.mobithink.server.dao.StationDataRepository;
import com.mobithink.server.entity.StationData;
import com.mobithink.server.service.StationDataService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by athiel on 03/02/2017.
 */

@Component()
@Transactional
public class StationDataServiceImpl implements StationDataService{

    @Resource
    StationDataRepository stationDataRepository;

    @Override
    public StationData createStationData(StationData stationData) {
        return stationDataRepository.save(stationData);
    }
}
