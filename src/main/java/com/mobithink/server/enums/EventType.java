package com.mobithink.server.enums;

/**
 * Created by mplaton on 26/04/2017.
 */
public enum EventType {

    EVENTINACTUALSECTION ("Evènement en section courante"), EVENTINCROSSROAD ("Evènement en carrefour"), EVENTINSTATION ("Evènement en station");

    private String name = "";

    EventType(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
