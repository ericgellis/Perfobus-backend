package com.mobithink.server.service.impl;

import com.mobithink.server.dao.RollingPointRepository;
import com.mobithink.server.entity.RollingPoint;
import com.mobithink.server.service.RollingPointService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

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
}
