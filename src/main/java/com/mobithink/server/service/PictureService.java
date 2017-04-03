package com.mobithink.server.service;

import com.mobithink.server.entity.Picture;
import java.util.List;

/**
 * Created by athiel on 06/02/2017.
 *
 */
public interface PictureService {

    Picture savedPicture (Picture picture);

    List<Picture> findByEventId (Long eventId);

}
