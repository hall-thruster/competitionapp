package com.competitionapp.one.flight;

import com.competitionapp.one.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private ParticipantService participantService;

    //Get list of all flights
    public List<Flight> getAllFlights(){
        List<Flight> flights = new ArrayList<>();
        flightRepository.findAll().forEach(flights::add);
        return flights;
    }

    //Get list of all flights for particular user
    public List<Flight> getParticipantFlights(String connectedParticipantId){
        List<Flight> flights = new ArrayList<>();
        flightRepository.findByConnectedParticipantId(connectedParticipantId).forEach(flights::add);
        return flights;
    }

    //Get sum of all flights for particular user
    public double calculateParticipantFlightsSum(String connectedParticipantId){
        double participantDistance = 0;
        List<Flight> flights = new ArrayList<>();
        flightRepository.findByConnectedParticipantId(connectedParticipantId).forEach(flights::add);
        for(Flight f : flights){
            participantDistance += f.getDistance();
        }
        return participantDistance;
    }

    //Get single flight as an object
    public Flight getFlight(int flightId){
        return flightRepository.findOne(flightId);
    }

    //Add flight
    public void addFlight(Flight flight) {
        flightRepository.save(flight);
    }

    //Update flight, also using 'save'
    public void updateFlight(Flight flight){
        flightRepository.save(flight);
    }

    //Delete existing flight
    public void deleteFlight(int flightId){
        flightRepository.delete(flightId);
    }

}
