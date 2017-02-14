package com.mobithink.server.facade;

import com.mobithink.server.exeption.MobithinkBusinessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by athiel on 10/02/2017.
 */

@RestController
@RequestMapping(value = "/mobithink/server" )
public class serverStatusFacade {

    /**
     *
     * GET. wake up server
     *
     *
     * @return  "success" or null
     *
     *
     */
    @GetMapping(path = "/wakeup", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public BodyBuilder wakeup() throws MobithinkBusinessException {
       return ResponseEntity.status(201);

    }
}
