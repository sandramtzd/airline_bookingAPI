package com.booking.airline.repositories;

import com.booking.airline.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    // Find all flights to Athens
    List<Flight> findByDestination(String destination);


}
