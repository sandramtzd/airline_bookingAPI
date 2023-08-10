package com.booking.airline.services;

import com.booking.airline.models.Flight;
import com.booking.airline.models.FlightDTO;
import com.booking.airline.models.Passenger;
import com.booking.airline.repositories.FlightRepository;
import com.booking.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;


//   SAVE A FLIGHT
    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    // DISPLAY ALL AVAILABLE FLIGHTS
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    // DISPLAY A SPECIFIC FLIGHT
    public Flight findFlight(Long id){
        return flightRepository.findById(id).get();
    }

    // DELETE A FLIGHT
    public void cancelFlight (Long id){
        flightRepository.deleteById(id);

    }

    // UPDATE A FLIGHT
    public void updateFlight (Flight flight, Long id){
        Flight flightToUpdate = flightRepository.findById(id).get();
        flightToUpdate.setDestination(flight.getDestination());
        flightToUpdate.setCapacity(flight.getCapacity());
        flightToUpdate.setDepartureDate(flight.getDepartureDate());
        flightToUpdate.setDepartureTime(flight.getDepartureTime());
        flightRepository.save(flightToUpdate);
    }

    // UPDATE PASSENGERS IN A FLIGHT

    public void bookingPassenger(Long id){
        Flight foundFlight = flightRepository.findById(id);
        for (Passenger passenger : foundFlight.getPassengers()){
            passenger.addFlight(foundFlight);
        }

    }










}
