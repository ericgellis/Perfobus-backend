package com.mobithink.server.service;

import com.mobithink.server.DTO.RollingPointDTO;
import com.mobithink.server.entity.RollingPoint;
import java.util.List;

/**
 * Created by athiel on 03/02/2017.
 *
 */
public interface RollingPointService {

    RollingPoint createRollingPoint(RollingPoint rollingPoint);

    List<RollingPointDTO> findRollingPOintDtoListByTripId(Long tripId);
}
