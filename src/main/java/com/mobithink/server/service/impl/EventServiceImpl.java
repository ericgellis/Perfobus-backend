package com.mobithink.server.service.impl;

import com.mobithink.server.dao.EventRepository;
import com.mobithink.server.entity.Event;
import com.mobithink.server.service.EventService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by athiel on 03/02/2017.
 */

@Component()
@Transactional
public class EventServiceImpl implements EventService {

    @Resource
    EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}
