package com.mobithink.server.dao;

import com.mobithink.server.entity.Station;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by athiel on 02/02/2017.
 *
 */
public interface StationRepository extends CrudRepository<Station, Long>{

    Station findByName (String name);
}
