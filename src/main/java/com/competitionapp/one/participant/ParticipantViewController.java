package com.competitionapp.one.participant;

import com.competitionapp.one.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParticipantViewController {

    @Autowired
    private ParticipantService participantService;
    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/participants", produces = "text/html")
    public String getAllParticipants(Model model){
        model.addAttribute("participants", participantService.getAllParticipants());
        return "participant_list";
    }

    @RequestMapping(value = "/participants/{participantId}", produces = "text/html")
    public String getParticipant(Model model, @PathVariable String participantId){
        model.addAttribute("participant", participantService.getParticipant(participantId));
        model.addAttribute("flights", flightService.getParticipantFlights(participantId));
        return "participant_profile";
    }

    @GetMapping("/participants/{participantId}/edit")
    public String updateParticipant(Model model, @PathVariable String participantId){
        model.addAttribute("participant", new Participant());
        model.addAttribute("participantId", participantId);
        return "participant_update";
    }

    @PostMapping("/participants/{participantId}/edit")
    public String participantUpdated(@ModelAttribute Participant participant, @PathVariable String participantId){
        participantService.updateParticipant(participantId, participant);
        return "participant_updated";
    }

    @GetMapping("/addparticipant")
    public String participantForm(Model model){
        model.addAttribute("participant", new Participant());
        return "participant_form";
    }

    @PostMapping("/addparticipant")
    public String addParticipant(@ModelAttribute Participant participant){
        participantService.addParticipant(participant);
        return "participant_submitted";
    }

}
