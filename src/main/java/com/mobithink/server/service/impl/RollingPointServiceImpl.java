package com.mobithink.server.service.impl;

import com.mobithink.server.DTO.ConverterOfDTO;
import com.mobithink.server.DTO.RollingPointDTO;
import com.mobithink.server.dao.RollingPointRepository;
import com.mobithink.server.entity.RollingPoint;
import com.mobithink.server.service.RollingPointService;
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
public class RollingPointServiceImpl implements RollingPointService {

    @Resource
    RollingPointRepository rollingPointRepository;

    @Override
    public RollingPoint createRollingPoint(RollingPoint rollingPoint) {
        return rollingPointRepository.save(rollingPoint);
    }

    @Override
    public List<RollingPointDTO> findRollingPOintDtoListByTripId(Long tripId) {
        List<RollingPoint> rollingPointList = rollingPointRepository.findAllByTripId(tripId);
        if (!(rollingPointList.isEmpty())){
            List<RollingPointDTO> rollingPointDTOList = new ArrayList<>();
            for (RollingPoint rollingPoint : rollingPointList){
                rollingPointDTOList.add(ConverterOfDTO.convretRollingPointToDto(rollingPoint));
            }
            return rollingPointDTOList;
        }
        return null;
    }
}
