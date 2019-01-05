package com.competitionapp.one.ranking;

import com.competitionapp.one.flight.FlightService;
import com.competitionapp.one.participant.Participant;
import com.competitionapp.one.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankingController {

    @Autowired
    private ParticipantService participantService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private RankingService rankingService;



    @RequestMapping("/ranking/overall")
    public List<Participant> getOverallRanking(){
        return rankingService.getOverallRanking();
    }

    @RequestMapping("/ranking/open")
    public List<Participant> getOpenRanking(){
        return rankingService.getOpenRanking();
    }

    @RequestMapping("/ranking/{categoryNumber}")
    public List<Participant> getCategoryRanking(@PathVariable int categoryNumber){
        return rankingService.getCategoryRanking(categoryNumber);
    }

}
