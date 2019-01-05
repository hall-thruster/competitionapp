package com.competitionapp.one.flight;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Integer> {

    public List<Flight> findByConnectedParticipantId(String participantId);

}
