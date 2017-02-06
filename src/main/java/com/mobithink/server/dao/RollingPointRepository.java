package com.mobithink.server.dao;

import com.mobithink.server.entity.RollingPoint;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by athiel on 03/02/2017.
 */
public interface RollingPointRepository extends CrudRepository<RollingPoint, Long> {

    List<RollingPoint> findAllByTripId(Long tripId);
}
