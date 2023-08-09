package com.booking.airline.models;

import java.util.List;

public class PassengerDTO {

    private String name;

    private String phoneNumber;

    private String emailAddress;

    private List<Long> flightIds;

    public PassengerDTO(String name, String phoneNumber, String emailAddress, List flightIds){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.flightIds = flightIds;
    }

    public PassengerDTO(){

    }

//    GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Long> getFlightIds() {
        return flightIds;
    }

    public void setFlightIds(List<Long> flightIds) {
        this.flightIds = flightIds;
    }
}
