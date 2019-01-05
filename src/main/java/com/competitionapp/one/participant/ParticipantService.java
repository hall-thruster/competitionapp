package com.competitionapp.one.participant;

import com.competitionapp.one.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipantService{

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private FlightService flightService;

    //Getting all participants
    public List<Participant> getAllParticipants(){
        List<Participant> participants = new ArrayList<>();
        participantRepository.findAll().forEach(participants::add);
        return participants;
    }

//    //Getting single participant
//    public Participant getParticipant(String participantId){
//        return participantRepository.findOne(participantId);
//    }

    //Getting single participant
    public Participant getParticipant(String participantId){
        Participant participant = participantRepository.findOne(participantId);
        return participant;
    }

    //Adding single participant
    public void addParticipant(Participant participant){
        participant.createBirthDateObject();
        participant.setAgeInYears(participant.calculateAgeInYears(participant.getBirthDate()));
        participant.setCategory(participant.assignAgeCategory(participant.getAgeInYears(), participant.isOpen()));
        participantRepository.save(participant);
    }

    //Updating participant, also by using 'save'
    public void updateParticipant(String participantId, Participant participant){
        participantRepository.save(participant);
    }

    //Deleting participant
    public void deleteParticipant(String participantId){
        participantRepository.delete(participantId);
    }

}
