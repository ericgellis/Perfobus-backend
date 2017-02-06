package com.mobithink.server.service;

import com.mobithink.server.DTO.EventDTO;
import com.mobithink.server.entity.Event;

import java.util.List;

/**
 * Created by athiel on 03/02/2017.
 */
public interface EventService {

    Event createEvent (Event event);

    List<EventDTO> findAllEventDTObyTripId(Long id);
}
