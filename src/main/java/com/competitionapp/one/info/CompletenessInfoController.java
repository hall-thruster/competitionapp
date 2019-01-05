package com.competitionapp.one.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompletenessInfoController {

    @Autowired
    private CompletenessInfoService completenessInfoService;

    @RequestMapping("/info/completeness")
    public double getPercentageOfFlightsPerformed(){
        return completenessInfoService.getPercentageOfFlightsPerformed();
    }


}
