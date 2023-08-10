package com.booking.airline.services;

import com.booking.airline.models.Flight;
import com.booking.airline.models.Passenger;
import com.booking.airline.models.PassengerDTO;
import com.booking.airline.repositories.FlightRepository;
import com.booking.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    // ADD A NEW PASSENGER
    public Passenger updatePassenger(PassengerDTO passengerDTO, Long id){
        Passenger passengerToUpdate = passengerRepository.findById(id).get();
        passengerToUpdate.setName(passengerDTO.getName());
        passengerToUpdate.setPhoneNumber(passengerDTO.getPhoneNumber());
        passengerToUpdate.setEmailAddress(passengerDTO.getEmailAddress());
        passengerToUpdate.setFlights(new ArrayList<Flight>());

        for (Long flightId : passengerDTO.getFlightIds()){
            Flight flight = flightRepository.findById(flightId).get();
            passengerToUpdate.addFlight(flight);
        }
        passengerRepository.save(passengerToUpdate);
        return passengerToUpdate;
    }

    // DISPLAY ALL PASSENGERS
    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }

    // DISPLAY A SPECIFIC PASSENGER
    public Passenger findPassenger(Long id){
        return passengerRepository.findById(id).get();
    }

    // SAVE PASSENGER
    public void savePassenger(PassengerDTO passengerDTO){
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getPhoneNumber(), passengerDTO.getEmailAddress());

        for (Long flightId : passengerDTO.getFlightIds()){
            Flight flight = flightRepository.findById(flightId).get();
            passenger.addFlight(flight);
        }
        passengerRepository.save(passenger);

    }

    // DELETE PASSENGER
    public void deletePassenger(Long id){
        passengerRepository.deleteById(id);
    }



}
