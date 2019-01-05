package com.competitionapp.one.info;

import com.competitionapp.one.flight.Flight;
import com.competitionapp.one.flight.FlightRepository;
import com.competitionapp.one.participant.Participant;
import com.competitionapp.one.participant.ParticipantRepository;
import com.competitionapp.one.participant.ParticipantService;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private ParticipantService participantService;

    //Get sum of all flights
    public double calculateFlightsSum(){
        double overallDistance = 0;
        List<Flight> flights = new ArrayList<>();
        flightRepository.findAll().forEach(flights::add);
        for(Flight f : flights){
            overallDistance += f.getDistance();
        }
        overallDistance = Precision.round(overallDistance, 2);

        return overallDistance;
    }

    //Get number of registered participants
    public int getNumberOfParticipants(){
        return (int) participantRepository.count();
    }

    //Get last participant
    public Participant getLatestParticipant(){
        //Getting last participant by listing all and getting last position on list, not very efficient
        //TODO: Find better way of getting last participant
        List<Participant> allParticipants = participantService.getAllParticipants();
        Participant latestParticipant = allParticipants.get(allParticipants.size() - 1);
        return latestParticipant;
    }
}
