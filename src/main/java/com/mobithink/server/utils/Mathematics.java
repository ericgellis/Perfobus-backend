package com.mobithink.server.utils;

import com.mobithink.server.DTO.EventDTO;
import com.mobithink.server.DTO.RollingPointDTO;
import com.mobithink.server.DTO.StationDataDTO;
import com.mobithink.server.DTO.TripDTO;
import com.mobithink.server.entity.RollingPoint;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by mplaton on 22/03/2017.
 */
public class Mathematics {

    double timeSaving;

    public EventDTO timeSavingCalculation (EventDTO eventDTO, TripDTO tripDTO){

        if (eventDTO.getStationName() == null){

            switch (eventDTO.getEventName()) {
                case "Giration difficile":
                    timeSaving = timeSavingEasyCalculation(eventDTO) * 0.18;
                    break;

                case "Voie étroite":
                    timeSaving = timeSavingEasyCalculation(eventDTO) * 0.1;
                    break;

                case "Chicane, écluse":
                    timeSaving = timeSavingEasyCalculation(eventDTO) * 0.109;
                    break;

                case "Dos d'âne, trapézoïdal":
                    timeSaving = timeSavingComplexCalculation(eventDTO, tripDTO);
                    break;

                case "Pavé trop rugueux":
                    timeSaving = 0;
                    break;

                case "Stationnement latéral":
                    timeSaving = timeSavingEasyCalculation(eventDTO) * 0.11;
                    break;

                case "Stationnement illicite":
                    timeSaving = timeSavingEasyCalculation(eventDTO) * 0.1;
                    break;

                case "Stationnement alterné (effet chicane)":
                    timeSaving = timeSavingEasyCalculation(eventDTO) * 0.109;
                    break;

                case "Passage à niveau":
                    timeSaving = timeSavingComplexCalculation(eventDTO, tripDTO);
                    break;

                case "Itinéraire en tiroir ou boucle":
                    timeSaving = timeSavingEasyCalculation(eventDTO);
                    break;

                case "Itinéraire sinueux":
                    timeSaving = 0;
                    break;

                case "Trafic":
                    timeSaving = timeSavingComplexCalculation(eventDTO, tripDTO);
                    break;

                case "Panne":
                    timeSaving = timeSavingEasyCalculation(eventDTO);
                    break;

                case "Giratoire : remontée des files d'attente":
                    timeSaving = timeSavingComplexCalculation(eventDTO, tripDTO);
                    break;

                case "Giratoire : attente":
                    timeSaving = timeSavingComplexCalculation(eventDTO, tripDTO);
                    break;

                case "Giratoire : giration trop importante":
                    timeSaving = timeSavingEasyCalculation(eventDTO) * 0.18;
                    break;

                case "Carrefour à feux : remontée des files d'attente":
                    timeSaving = timeSavingComplexCalculation(eventDTO, tripDTO);
                    break;

                case "Carrefour à feux : attente":
                    timeSaving = timeSavingComplexCalculation(eventDTO, tripDTO);
                    break;

                case "Carrefour à feux : étroit car îlot refuge":
                    timeSaving = timeSavingEasyCalculation(eventDTO) * 0.1;
                    break;

                case "Carrefour à feux : ligne de feu trop avancée":
                    timeSaving = timeSavingEasyCalculation(eventDTO) * 0.1;
                    break;

                default:
                    break;

            }
        } else {
            switch (eventDTO.getEventName()) {
                case "Trop d'arrêts":
                    timeSaving = timeSavingComplexCalculation(eventDTO, tripDTO);
                    break;

                case "Stationnement illicite":
                    timeSaving = timeSavingEasyCalculation(eventDTO);
                    break;

                case "Attente pour correspondance":
                    timeSaving = timeSavingEasyCalculation(eventDTO);
                    break;

                case "Capacité station":
                    timeSaving = 0 ;
                    break;

                case "Foule":
                    timeSaving = 0;
                    break;

                case "Incivilité":
                    timeSaving = timeSavingEasyCalculation(eventDTO);
                    break;

                case "Demande d'informations à bord":
                    timeSaving = timeSavingEasyCalculation(eventDTO)*0.8;
                    break;

                case "Vente à bord et échange de monnaie":
                    timeSaving = timeSavingEasyCalculation(eventDTO)*0.8;
                    break;

                case "Réinsertion dans la circulation":
                    timeSaving = timeSavingEasyCalculation(eventDTO);
                    break;

                case "PMR":
                    timeSaving = 0;
                    break;

                case "Incident technique":
                    timeSaving = 0;
                    break;

                default:
                    break;
            }
        }

        eventDTO.setTimeSaving((long) timeSaving);
        return eventDTO;
    }

    public RollingPointDTO speedBetweenRollingPointsCalculation (RollingPointDTO rollingPointDTO, TripDTO tripDTO) {
        double speed = 0;
        for (int i = 1 ; i<tripDTO.getRollingPointDTOList().size(); i++){
            RollingPointDTO currentRollingPointDTO = tripDTO.getRollingPointDTOList().get(i-1);
            RollingPointDTO nextRollingPointDTO = tripDTO.getRollingPointDTOList().get(i);
            speed = (calculateGPSDistance(currentRollingPointDTO.getGpsLat(), currentRollingPointDTO.getGpsLong(), nextRollingPointDTO.getGpsLat(), nextRollingPointDTO.getGpsLong())/(nextRollingPointDTO.getPointTime()-currentRollingPointDTO.getPointTime()));
        }

        rollingPointDTO.setSpeed(speed);
        return rollingPointDTO;
    }

    private static Double convertRad(Double input){
        return (Math.PI * input)/180;
    }

    private static Double calculateGPSDistance(Double lat_a_degre, Double lon_a_degre, Double lat_b_degre, Double lon_b_degre){
        Double distance;
        int R = 6378000; //Earth radius in meter

        Double lat_a = convertRad(lat_a_degre);
        Double lon_a = convertRad(lon_a_degre);
        Double lat_b = convertRad(lat_b_degre);
        Double lon_b = convertRad(lon_b_degre);

        distance = R * (Math.PI/2 - Math.asin( Math.sin(lat_b) * Math.sin(lat_a) + Math.cos(lon_b - lon_a) * Math.cos(lat_b) * Math.cos(lat_a)));
        return distance;
    }

    private int timeSavingEasyCalculation(EventDTO eventDTO){
        double time = 0;
        time = (eventDTO.getEndTime()-eventDTO.getStartTime());
        int minutes = (int) ((time / (1000*60)) % 60);
        return minutes;
    }

    private int timeSavingComplexCalculation(EventDTO eventDTO, TripDTO tripDTO){
        double time = 0;

            for (int i = 1 ; i<tripDTO.getStationDataDTOList().size(); i++) {
                StationDataDTO currentStationDataDTO = tripDTO.getStationDataDTOList().get(i-1);
                StationDataDTO nextStationDataDTO = tripDTO.getStationDataDTOList().get(i);
                if (eventDTO.getStartTime() > currentStationDataDTO.getEndTime() && eventDTO.getStartTime() < nextStationDataDTO.getStartTime()){
                    time = (eventDTO.getEndTime() - eventDTO.getStartTime()) - ((calculateGPSDistance(eventDTO.getGpsLat()
                            , eventDTO.getGpsLong(), eventDTO.getGpsEndLat(), eventDTO.getGpsEndLong())) /
                            (calculateGPSDistance(currentStationDataDTO.getGpsLat(), currentStationDataDTO.getGpsLong(), nextStationDataDTO.getGpsLat(), nextStationDataDTO.getGpsLong())
                                    / (nextStationDataDTO.getEndTime() - currentStationDataDTO.getStartTime())));
                }
            }
        int minutes = (int) ((time / (1000*60)) % 60);
        return minutes;
    }
}
