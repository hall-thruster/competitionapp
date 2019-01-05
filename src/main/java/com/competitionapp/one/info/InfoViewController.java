package com.competitionapp.one.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoViewController {

    @Autowired
    private InfoService infoService;
    @Autowired
    private CompletenessInfoService completenessInfoService;

    @RequestMapping(value = "/info", produces = "text/html")
    public String getInfoPage(Model model){
        model.addAttribute("overallDistance", infoService.calculateFlightsSum());
        model.addAttribute("numberOfParticipants", infoService.getNumberOfParticipants());
        model.addAttribute("latestParticipant", infoService.getLatestParticipant());
        model.addAttribute("completenessPercentage", completenessInfoService.getPercentageOfFlightsPerformed());
        return "info";
    }

}
