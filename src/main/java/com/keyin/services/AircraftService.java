package com.keyin.services;

import com.keyin.models.Aircraft;
import com.keyin.models.Passenger;
import com.keyin.models.Airport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AircraftService {
    private Map<Long, Aircraft> aircraftMap = new HashMap<>();
    private long currentId = 1;

    public List<Aircraft> getAllAircraft() {
        return List.copyOf(aircraftMap.values());
    }

    public Aircraft getAircraftById(Long id) {
        return aircraftMap.get(id);
    }

    public Aircraft createAircraft(Aircraft aircraft) {
        aircraft.setId(currentId);  // Set the ID for the aircraft
        aircraftMap.put(currentId, aircraft); // Add the aircraft to the map
        currentId++; // Increment the ID for the next aircraft
        return aircraft;
    }

    public Aircraft updateAircraft(Long id, Aircraft aircraftDetails) {
        Aircraft aircraft = aircraftMap.get(id);
        if (aircraft != null) {
            aircraft.setType(aircraftDetails.getType());
            aircraft.setAirlineName(aircraftDetails.getAirlineName());
            aircraft.setNumberOfPassengers(aircraftDetails.getNumberOfPassengers());
            aircraft.setPassengers(aircraftDetails.getPassengers());
            aircraft.setAirports(aircraftDetails.getAirports());
            aircraftMap.put(id, aircraft); // Update the map with new details
        }
        return aircraft;
    }

    public void deleteAircraft(Long id) {
        aircraftMap.remove(id);
    }

    public List<Airport> getAircraftAirports(Long id) {
        Aircraft aircraft = aircraftMap.get(id);
        if (aircraft != null) {
            return aircraft.getAirports();
        }
        return new ArrayList<>();
    }

    public List<Passenger> getAircraftPassengers(Long id) {
        Aircraft aircraft = aircraftMap.get(id);
        if (aircraft != null) {
            return aircraft.getPassengers();
        }
        return new ArrayList<>();
    }
}

