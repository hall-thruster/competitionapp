package com.competitionapp.one.participant;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Participant{

    //Fields provided during registering new participant
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private boolean open;

    //Fields provided by class methods during creating participant object, based on other fields
    private LocalDate birthDate;
    private int ageInYears;
    private double flightLengthSum;
    private int category;

    //Flights counter, for identyfying particular participant's flights
    private int flightCounter = 1;

    public Participant(){System.out.println("Using empty constructor");}

    public Participant(String id, String firstName, String lastName, int birthYear, int birthMonth, int birthDay, boolean open){
        //Assigning "direct" fields
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.open = open;

        //TODO: How to calculate "indirect" fields from constructor? Spring always uses empty constructor
        System.out.println("Using constructor with arguments");
    }

    public void createBirthDateObject(){
        this.birthDate = LocalDate.of(this.birthYear, this.birthMonth, this.birthDay);
    }

    //Calculating participant age
    public int calculateAgeInYears(LocalDate birthDate){
        Period accurateAge = Period.between(birthDate, LocalDate.now());
        return accurateAge.getYears();
    }

    //Assigning category based on age
    //Default categories:
    //0-6 -> 1, small model
    //7-12 -> 2, big model
    //13 - 16 -> 3, big model
    //>16 -> 4, big model
    //open category -> 5, custom model
    //Categories may change in future
    public int assignAgeCategory(int ageInYears, boolean open){
        if ((ageInYears <= 6) && (open == false)){ return 1; }
        if ((ageInYears > 6) && (ageInYears <=12) && (open == false)){ return 2; }
        if ((ageInYears > 12) && (ageInYears <= 16) && (open == false)){ return 3; }
        if ((ageInYears > 16) && (open == false)){ return 4; }
        if (open == true){ return 5; }
        else { return -1; }
    }

    //Getters and setters section
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getFlightLengthSum() {
        return flightLengthSum;
    }
    public void setFlightLengthSum(double flightLengthSum) {
        this.flightLengthSum = flightLengthSum;
    }

    public int getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }
    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(int ageInYears) {
        this.ageInYears = ageInYears;
    }
}
