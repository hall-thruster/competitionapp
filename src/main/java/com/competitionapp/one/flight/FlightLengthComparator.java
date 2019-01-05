package com.competitionapp.one.flight;

import com.competitionapp.one.participant.Participant;

import java.util.Comparator;

public class FlightLengthComparator implements Comparator<Participant> {

    public int compare(Participant firstParticipant, Participant secondParticipant){
        return Double.compare(secondParticipant.getFlightLengthSum(), firstParticipant.getFlightLengthSum());
    }

}
