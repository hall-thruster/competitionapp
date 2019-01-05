package com.competitionapp.one.ranking;

import com.competitionapp.one.flight.FlightLengthComparator;
import com.competitionapp.one.flight.FlightRepository;
import com.competitionapp.one.flight.FlightService;
import com.competitionapp.one.participant.Participant;
import com.competitionapp.one.participant.ParticipantRepository;
import com.competitionapp.one.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RankingService {

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private FlightService flightService;



    //Getting overall participants ranking
    public List<Participant> getOverallRanking(){
        List<Participant> allParticipants = new ArrayList<>();
        participantRepository.findAll().forEach(allParticipants::add);
        for(Participant p : allParticipants){
            p.setFlightLengthSum(flightService.calculateParticipantFlightsSum(p.getId()));
        }
        Collections.sort(allParticipants, new FlightLengthComparator());
        return allParticipants;
    }

    //Generate ranking for OPEN class, moved to separate method for regularity
    public List<Participant> getOpenRanking(){
        List<Participant> allParticipants = new ArrayList<>();
        List<Participant> openParticipantsRanking = new ArrayList<>();
        participantRepository.findAll().forEach(allParticipants::add);
        for(Participant p : allParticipants){
            if(p.getCategory() == 5){
                p.setFlightLengthSum(flightService.calculateParticipantFlightsSum(p.getId()));
                openParticipantsRanking.add(p);
            }
        }
        Collections.sort(openParticipantsRanking, new FlightLengthComparator());
        return openParticipantsRanking;
    }

    //Generate ranking for given category
    public List<Participant> getCategoryRanking(int categoryNumber){
        List<Participant> allParticipants = new ArrayList<>();
        List<Participant> categoryParticipantsRanking = new ArrayList<>();
        participantRepository.findAll().forEach(allParticipants::add);
        for (Participant p : allParticipants){
            if(p.getCategory() == categoryNumber){
                p.setFlightLengthSum(flightService.calculateParticipantFlightsSum(p.getId()));
                categoryParticipantsRanking.add(p);
            }
        }
        Collections.sort(categoryParticipantsRanking, new FlightLengthComparator());
        return categoryParticipantsRanking;
    }

}
