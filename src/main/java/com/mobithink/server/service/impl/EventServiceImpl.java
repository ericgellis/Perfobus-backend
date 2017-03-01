package com.mobithink.server.service.impl;

import com.mobithink.server.DTO.ConverterOfDTO;
import com.mobithink.server.DTO.EventDTO;
import com.mobithink.server.dao.EventRepository;
import com.mobithink.server.dao.PictureRepository;
import com.mobithink.server.entity.Event;
import com.mobithink.server.entity.Picture;
import com.mobithink.server.service.EventService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by athiel on 03/02/2017.
 * 
 */

@Component()
@Transactional
public class EventServiceImpl implements EventService {

    @Resource
    EventRepository eventRepository;

    @Resource
    PictureRepository pictureRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<EventDTO> findAllEventDTObyTripId(Long id) {
        List<Event> eventList = eventRepository.findAllByTripId(id);
        if (!(eventList.isEmpty())) {
            List<EventDTO> eventDTOList = new ArrayList<>();
            for (Event event : eventList){
                List<Picture> pictureList = pictureRepository.findByEventId(event.getId());
                eventDTOList.add(ConverterOfDTO.convertEventToDto(event, pictureList));
            }
            return eventDTOList;
        }else return null;
    }
}
