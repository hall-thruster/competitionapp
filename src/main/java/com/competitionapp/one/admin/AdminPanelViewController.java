package com.competitionapp.one.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelViewController {

    @GetMapping("/")
    public String displayAdminPanel(){
        return "index";
    }

}
