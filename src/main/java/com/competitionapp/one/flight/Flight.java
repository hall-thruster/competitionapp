package com.competitionapp.one.flight;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {

    @Autowired
    private static FlightRepository flightRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uniqueFlightId;

    private double distance;
    private String connectedParticipantId;


    public Flight(){
        System.out.println("Using empty flight constructor");
    }

    public Flight(double distance){
        super();
        this.distance = distance;
        System.out.println("Using standard flight constructor");
    }

    //Getters and setters section
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getConnectedParticipantId(){
        return connectedParticipantId;
    }
    public void setConnectedParticipantId(String connectedParticipantId){
        this.connectedParticipantId = connectedParticipantId;
    }

    public int getUniqueFlightId(){
        return uniqueFlightId;
    }
}
