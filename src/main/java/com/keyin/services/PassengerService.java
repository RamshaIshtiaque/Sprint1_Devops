package com.keyin.services;

import com.keyin.models.Passenger;
import com.keyin.models.Aircraft;
import com.keyin.models.Airport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PassengerService {
    private Map<Long, Passenger> passengerMap = new HashMap<>();
    private long currentId = 1;

    public Map<Long, Passenger> getAllPassengers() {
        return passengerMap;
    }

    public Passenger getPassengerById(Long id) {
        return passengerMap.get(id);
    }

    public Passenger createPassenger(Passenger passenger) {
        passenger.setId(currentId);  // Set the ID for the passenger
        passengerMap.put(currentId, passenger); // Add the passenger to the map
        currentId++; // Increment the ID for the next passenger
        return passenger;
    }

    public Passenger updatePassenger(Long id, Passenger passengerDetails) {
        Passenger passenger = passengerMap.get(id);
        if (passenger != null) {
            passenger.setFirstName(passengerDetails.getFirstName());
            passenger.setLastName(passengerDetails.getLastName());
            passenger.setPhoneNumber(passengerDetails.getPhoneNumber());
            passenger.setCity(passengerDetails.getCity());
            passenger.setAircraftList(passengerDetails.getAircraftList());
            passengerMap.put(id, passenger); // Update the map with new details
        }
        return passenger;
    }

    public void deletePassenger(Long id) {
        passengerMap.remove(id);
    }

    public List<Aircraft> getPassengerAircrafts(Long id) {
        Passenger passenger = passengerMap.get(id);
        if (passenger != null) {
            return passenger.getAircraftList();
        }
        return new ArrayList<>();
    }

    public List<Airport> getPassengerAirports(Long id) {
        Passenger passenger = passengerMap.get(id);
        if (passenger != null) {
            List<Airport> airports = new ArrayList<>();
            for (Aircraft aircraft : passenger.getAircraftList()) {
                airports.addAll(aircraft.getAirports());
            }
            return airports;
        }
        return new ArrayList<>();
    }
}

