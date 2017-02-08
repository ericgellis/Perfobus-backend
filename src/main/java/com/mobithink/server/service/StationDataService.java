package com.mobithink.server.service;

import com.mobithink.server.DTO.StationDataDTO;
import com.mobithink.server.entity.StationData;
import java.util.List;

/**
 * Created by athiel on 03/02/2017.
 *
 */
public interface StationDataService {

    StationData createStationData(StationData stationData);

    StationData findStationDataByStationName (String stationName);

    List<StationDataDTO> findAllStationDataDtoByTripId (Long tripId);
}
