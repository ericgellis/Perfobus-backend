package com.mobithink.server.dao;

import com.mobithink.server.entity.StationData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by athiel on 03/02/2017.
 *
 */
public interface StationDataRepository extends CrudRepository<StationData, Long> {

    StationData findByStationName (String stationName);

    List<StationData> findAllByTripId (Long tripId);
}
