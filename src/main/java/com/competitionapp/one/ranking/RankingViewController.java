package com.competitionapp.one.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RankingViewController {

    @Autowired
    private RankingService rankingService;

    //Controller for ranking choosing site
    @GetMapping("/ranking")
    public String chooseRanking(){
        return "ranking_choose";
    }

    @GetMapping("/ranking/overall")
    public String getOverallRanking(Model model){
        model.addAttribute("ranking", rankingService.getOverallRanking());
        model.addAttribute("category", "ogólnej");
        return "ranking";
    }

    @GetMapping("/ranking/1")
    public String getFirstCategoryRanking(Model model){
        model.addAttribute("ranking", rankingService.getCategoryRanking(1));
        model.addAttribute("category", "1");
        return "ranking";
    }

    @GetMapping("/ranking/2")
    public String getSecondCategoryRanking(Model model){
        model.addAttribute("ranking", rankingService.getCategoryRanking(2));
        model.addAttribute("category", "2");
        return "ranking";
    }

    @GetMapping("/ranking/3")
    public String getThirdCategoryRanking(Model model){
        model.addAttribute("ranking", rankingService.getCategoryRanking(3));
        model.addAttribute("category", "3");
        return "ranking";
    }

    @GetMapping("/ranking/4")
    public String getFourthCategoryRanking(Model model){
        model.addAttribute("ranking", rankingService.getCategoryRanking(4));
        model.addAttribute("category", "4");
        return "ranking";
    }

    @GetMapping("/ranking/open")
    public String getOpenRanking(Model model){
        model.addAttribute("ranking", rankingService.getOpenRanking());
        model.addAttribute("category", "OPEN");
        return "ranking";
    }


}
