package com.booking.airline.controllers;

import com.booking.airline.models.BookingDTO;
import com.booking.airline.models.Flight;
import com.booking.airline.models.FlightDTO;
import com.booking.airline.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;


    // CREATE. Add a new flight
    @PostMapping
    public ResponseEntity<List<Flight>> postFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity(flightService.findAllFlights(), HttpStatus.CREATED);
    }

    // INDEX. Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity(flightService.findAllFlights(), HttpStatus.OK);
    }

    // SHOW. Display details of a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlight(@PathVariable Long id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Flight> updateFlight (@RequestBody Flight flight, @PathVariable Long id){
        flightService.updateFlight(flight, id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }



    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        flightService.cancelFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    // BOOKING A PASSENGER ONTO A FLIGHT
    @PutMapping(value = "/{id}")
    public ResponseEntity<Flight> bookingPassenger (@RequestBody BookingDTO bookingDTO, @PathVariable Long id){
        flightService.updateFlight(flight, id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }













}
