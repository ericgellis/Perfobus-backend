package com.mobithink.server.dao;

import com.mobithink.server.entity.Picture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by athiel on 06/02/2017.
 */
public interface PictureRepository extends CrudRepository<Picture, Long> {

    List<Picture> findByEventId (Long eventId);

    List<Picture> findByStationDataId (Long stationDataId);
}
