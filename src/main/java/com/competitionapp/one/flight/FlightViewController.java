package com.competitionapp.one.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FlightViewController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/addflight")
    public String addFlight(@ModelAttribute Flight flight){
        flightService.addFlight(flight);
        return "flight_submitted";
    }

    @GetMapping("/addflight")
    public String flightForm(Model model){
        model.addAttribute("flight", new Flight());
        return "flight_form";
    }

}
