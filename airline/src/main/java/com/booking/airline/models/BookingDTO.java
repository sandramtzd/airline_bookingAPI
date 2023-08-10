package com.booking.airline.models;

public class BookingDTO {

    private Long passengerId;

    private Long flightId;

    public BookingDTO(Long passengerId, Long flightId){
        this.passengerId = passengerId;
        this.flightId = flightId;

    }

    public BookingDTO(){

    }

//    GETTERS AND SETTERS

    public Long getPassengerId(){
        return passengerId;
    }

    public void setPassengerId(Long passengerId){
        this.passengerId = passengerId;
    }

    public Long getFlightId(){
        return flightId;

    }

    public void setFlightId(Long flightId){
        this.flightId = flightId;
    }



}
