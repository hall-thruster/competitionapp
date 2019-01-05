package com.competitionapp.one.info;

import com.competitionapp.one.flight.FlightRepository;
import com.competitionapp.one.participant.ParticipantRepository;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompletenessInfoService {

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private FlightRepository flightRepository;

    //Get percentage of flights performed, regardless of the category
    //Assuming that every participant performs 5 flights
    public double getPercentageOfFlightsPerformed(){
        double numberOfParticipants = participantRepository.count();
        double numberOfFlightsPerformed = flightRepository.count();
        double flightsTotal = numberOfParticipants * 5;

        double percentageCompleted = Precision.round(((numberOfFlightsPerformed/flightsTotal)*100), 2);

        return percentageCompleted;
    }

    //TODO: Calculating percentage of flights performed for particular class
    //TODO: Change calculations to BigDecimal to avoid strange mistakes
}
