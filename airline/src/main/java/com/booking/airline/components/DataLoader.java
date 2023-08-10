package com.booking.airline.components;

import com.booking.airline.models.Flight;
import com.booking.airline.models.Passenger;
import com.booking.airline.repositories.FlightRepository;
import com.booking.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

        // British Airways

        Flight britishAirways1 = new Flight("Barcelona", 50, "15/08/2023", "18:00");
        flightRepository.save(britishAirways1);

        Flight britishAirways2 = new Flight("Prague", 40, "20/11/2023", "09:00");
        flightRepository.save(britishAirways2);

        Passenger sandraMartinez = new Passenger("Sandra Martinez", "07852489560", "sandra@hotmail.com");
        sandraMartinez.addFlight(britishAirways1);
        passengerRepository.save(sandraMartinez);

        Passenger abdulazisA = new Passenger("Abdulasiz A", "07756789260", "abdulasiz@hotmail.com");
        abdulazisA.addFlight(britishAirways2);
        passengerRepository.save(abdulazisA);

        Passenger amelieBoyd = new Passenger("Amelie Boyd", "07459009165", "abdulasiz@hotmail.com");
        amelieBoyd.addFlight(britishAirways2);
        passengerRepository.save(amelieBoyd);

        // American Airlines

        Flight americanAirlines1 = new Flight ("New York", 70, "22/12/2023", "10:00");
        flightRepository.save(americanAirlines1);

        Flight americanAirlines2 = new Flight ("Chicago", 100, "10/08/2023", "21:00");
        flightRepository.save(americanAirlines2);

        Passenger blezzyDela = new Passenger("Blezzy Dela", "06734567892", "blezzy@outlook.com");
        blezzyDela.addFlight(americanAirlines1);
        passengerRepository.save(blezzyDela);

        Passenger callumBatten = new Passenger("Callum Batten", "08456784930", "callum@gmail.com");
        callumBatten.addFlight(americanAirlines2);
        passengerRepository.save(callumBatten);

        Passenger carolinaHorman = new Passenger("Carolina Horman", "07853490349", "carolina@outlook.com");
        carolinaHorman.addFlight(americanAirlines1);
        passengerRepository.save(carolinaHorman);

        // United Airlines

        Flight unitedAirlines1 = new Flight ("Munich", 30, "06/09/2023", "14:00");
        flightRepository.save(unitedAirlines1);

        Flight unitedAirlines2 = new Flight ("Athens", 50, "23/08/2023", "06:00");
        flightRepository.save(unitedAirlines2);

        Passenger charlotteGould = new Passenger("Charlotte Gould", "08909354678", "charlotte@gmail.com");
        charlotteGould.addFlight(unitedAirlines1);
        passengerRepository.save(charlotteGould);

        Passenger faranMuhammad = new Passenger("Faran Muhammad", "07854398470", "faran@hotmail.com");
        faranMuhammad.addFlight(unitedAirlines2);
        passengerRepository.save(faranMuhammad);

        Passenger francescaMarshall = new Passenger("Francesca Marshall", "07853490349", "francesca@outlook.com");
        carolinaHorman.addFlight(unitedAirlines1);
        passengerRepository.save(francescaMarshall);

        // Ryanair

        Flight ryanair1 = new Flight ("Munich", 10, "15/11/2023", "10:00");
        flightRepository.save(ryanair1);

        Flight ryanair2 = new Flight ("Athens", 15, "10/08/2023", "11:00");
        flightRepository.save(ryanair2);

        Flight ryanair3 = new Flight("Barcelona", 80, "12/08/2023", "23:00");
        flightRepository.save(ryanair3);

        Flight ryanair4 = new Flight("Prague", 100, "21/10/2023", "12:00");
        flightRepository.save(ryanair4);

        // PatitoAir

        Flight patitoAir1 = new Flight ("Munich", 10, "15/08/2024", "00:00");
        flightRepository.save(patitoAir1);

        Flight patitoAir2 = new Flight ("Athens", 15, "10/02/2024", "07:00");
        flightRepository.save(patitoAir2);

        Flight patitoAir3 = new Flight("Barcelona", 80, "12/01/2024", "19:40");
        flightRepository.save(patitoAir3);

        Flight patitoAir4 = new Flight("Prague", 100, "21/03/2024", "09:50");
        flightRepository.save(patitoAir4);




    }



}
