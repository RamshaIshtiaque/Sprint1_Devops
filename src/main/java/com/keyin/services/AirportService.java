package com.keyin.services;

import com.keyin.models.Airport;
import com.keyin.models.City;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AirportService {
    private Map<Integer, Airport> airportMap = new HashMap<>();
    private int currentId = 1;

    public List<Airport> getAllAirports() {
        return List.copyOf(airportMap.values());
    }

    public Airport getAirportById(Integer id) {
        return airportMap.get(id);
    }

    public Airport createAirport(Airport airport) {
        airport.setId(currentId);  // Set the ID for the airport
        airportMap.put(currentId, airport); // Add the airport to the map
        currentId++; // Increment the ID for the next airport
        return airport;
    }

    public Airport updateAirport(Integer id, Airport airportDetails) {
        Airport airport = airportMap.get(id);
        if (airport != null) {
            airport.setName(airportDetails.getName());
            airport.setCode(airportDetails.getCode());
            airport.setCity(airportDetails.getCity());
            airportMap.put(id, airport); // Update the map with new details
        }
        return airport;
    }

    public void deleteAirport(Integer id) {
        airportMap.remove(id);
    }

    public City getAirportInCity(Integer id) {
        Airport airport = airportMap.get(id);
        if (airport != null) {
            City city = airport.getCity();
            return city;
        }
        return null;
    }
}

