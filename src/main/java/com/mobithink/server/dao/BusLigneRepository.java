package com.mobithink.server.dao;

import com.mobithink.server.entity.BusLine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by athiel on 01/02/2017.
 */
public interface BusLigneRepository extends CrudRepository<BusLine, Long> {

    List<BusLine> findByCityId(Long id);

    BusLine findOneByName(String name);

}
