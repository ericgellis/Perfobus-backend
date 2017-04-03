package com.mobithink.server.service.impl;

import com.mobithink.server.dao.PictureRepository;
import com.mobithink.server.entity.Picture;
import com.mobithink.server.service.PictureService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by athiel on 06/02/2017.
 */

@Component()
@Transactional
public class PictureServiceImpl implements PictureService {

    @Resource
    PictureRepository pictureRepository;

    @Override
    public Picture savedPicture(Picture picture) {
        return pictureRepository.save(picture);
    }

    @Override
    public List<Picture> findByEventId(Long eventId) {
        return pictureRepository.findByEventId(eventId);
    }


}
