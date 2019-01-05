package com.competitionapp.one.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/info/sum")
    public double getFlightsSum(){
        return infoService.calculateFlightsSum();
    }

}
