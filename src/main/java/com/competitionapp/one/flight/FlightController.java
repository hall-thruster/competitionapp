package com.competitionapp.one.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping("/flights")
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @RequestMapping("/flights/{flightId}")
    public Flight getFlight(@PathVariable int flightId){
        return flightService.getFlight(flightId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "participants/{connectedParticipantId}/flights")
    public void addFlight(@RequestBody Flight flight, @PathVariable String connectedParticipantId){
        flight.setConnectedParticipantId(connectedParticipantId);
        flightService.addFlight(flight);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "participants/{connectedParticipantId}/flights/{flightId}")
    public void updateFlight(@RequestBody Flight flight){
        flightService.updateFlight(flight);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/participants/{connectedParticipantId}/flights/{flightId}")
    public void deleteFlight(@PathVariable int flightId){
        flightService.deleteFlight(flightId);
    }

}
