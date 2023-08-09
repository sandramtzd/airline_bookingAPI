package com.booking.airline.controllers;

import com.booking.airline.models.Passenger;
import com.booking.airline.models.PassengerDTO;
import com.booking.airline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    // INDEX. Display details of all passengers

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity(passengerService.findAllPassengers(), HttpStatus.OK);
    }

    // SHOW. Display details of a specific passenger
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        Passenger foundPassenger = passengerService.findPassenger(id);
        return new ResponseEntity(foundPassenger, HttpStatus.OK);
    }

    // CREATE. Add a new passenger
    @PostMapping
    public ResponseEntity<List<Passenger>> postPassenger(@RequestBody PassengerDTO passengerDTO){
        passengerService.savePassenger(passengerDTO);
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.CREATED);
    }

    //    UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Passenger> updatePassenger(@RequestBody PassengerDTO passengerDTO, @PathVariable Long id){
        Passenger updatedPassenger = passengerService.updatePassenger(passengerDTO, id);
        return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
    }

    //    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deletePassenger(@PathVariable Long id){
        passengerService.deletePassenger(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



}
