package com.booking.airline.services;

import com.booking.airline.models.Flight;
import com.booking.airline.repositories.FlightRepository;
import com.booking.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;


    public void updateFlight (Flight flight, Long id){
        Flight flightToUpdate = flightRepository.findById(id).get();
        flightToUpdate.setDestination(flight.getDestination());
        flightToUpdate.setCapacity(flight.getCapacity());
        flightToUpdate.setDepartureDate(flight.getDepartureDate());
        flightToUpdate.setDepartureTime(flight.getDepartureTime());
        flightRepository.save(flightToUpdate);
    }


    // Display all available flights
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    // Display details of a specific flight
    public Flight findFlight(Long id){
        return flightRepository.findById(id).get();
    }

    // Cancel a flight
    public void cancelFlight (Long id){
        flightRepository.deleteById(id);
    }

    public void saveFlight (Flight flight){
        flightRepository.save(flight);
    }








}
