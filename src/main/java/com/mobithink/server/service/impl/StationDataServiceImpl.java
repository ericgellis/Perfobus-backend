package com.mobithink.server.service.impl;

import com.mobithink.server.DTO.ConverterOfDTO;
import com.mobithink.server.DTO.StationDataDTO;
import com.mobithink.server.dao.StationDataRepository;
import com.mobithink.server.entity.StationData;
import com.mobithink.server.service.StationDataService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public StationData findStationDataByStationName(String stationName) {
        return stationDataRepository.findByStationName(stationName);
    }

    @Override
    public List<StationDataDTO> findAllStationDataDtoByTripId(Long tripId) {
        List<StationData> stationDataList = stationDataRepository.findAllByTripId(tripId);

        List<StationDataDTO> stationDataDTOList = new ArrayList<>();
        if (stationDataList != null) {
            for (StationData stationData : stationDataList) {
                stationDataDTOList.add(ConverterOfDTO.convertStationDataToDto(stationData));
            }
            return stationDataDTOList;
        } else return null;
    }
}
