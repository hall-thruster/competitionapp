package com.competitionapp.one.participant;

import com.competitionapp.one.flight.Flight;
import com.competitionapp.one.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;
    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/participants", produces = "application/json")
    public List<Participant> getAllParticipants(){
        return participantService.getAllParticipants();
    }

//    @RequestMapping("/participants")
//    public String getAllParticipants(Model model){
//        model.addAttribute("participants", participantService.getAllParticipants());
//        return "ParticipantView";
//    }

//    @RequestMapping("/participants/{participantId}")
//    public Participant getParticipant(@PathVariable String participantId){
//        return participantService.getParticipant(participantId);
//    }

    @RequestMapping("/participants/{participantId}/flights")
    public List<Flight> getParticiantFlights(@PathVariable String participantId){
        return flightService.getParticipantFlights(participantId);
    }

    @RequestMapping("/participants/{participantId}/flights/sum")
    public double getParticipantFlightsSum(@PathVariable String participantId){
        return flightService.calculateParticipantFlightsSum(participantId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/participants")
    public void addParticipant(@RequestBody Participant participant){
        participantService.addParticipant(participant);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/participants/{participantId}")
    public void updateParticipant(@PathVariable String participantId, @RequestBody Participant participant){
        participantService.updateParticipant(participantId, participant);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/participants/{participantId}")
    public void deleteParticipant(@PathVariable String participantId){
        participantService.deleteParticipant(participantId);
    }
}
