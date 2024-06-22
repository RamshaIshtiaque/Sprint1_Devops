package com.keyin.services;

import com.keyin.models.Airport;
import com.keyin.models.City;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityService {

    private Map<Integer, City> cityMap = new HashMap<Integer, City>();
    private int currentId = 1;

    public City getCity(Integer id) {
        return cityMap.get(id);
    }


    public List<City> getAllCities() {
        return List.copyOf(cityMap.values());
    }

    public City createCity(City city) {
        city.setId(currentId);  // Set the ID for the city
        cityMap.put(currentId, city); // Add the city to the map
        currentId++; // Increment the ID for the next city
        return city;
    }

    public City updateCity(Integer id, City cityDetails) {
        City city = cityMap.get(id);
        if (city != null) {
            city.setName(cityDetails.getName());
            city.setState(cityDetails.getState());
            city.setPopulation(cityDetails.getPopulation());
            cityMap.put(id, city); // Update the map with new details
        }
        return city;
    }

    public void deleteCity(Integer id) {
        cityMap.remove(id);
    }

    public List<Airport> getAirportsInCity(Long id) {
        City city = cityMap.get(id);
        if (city != null) {
            return city.getAirports();
        }
        return null;

    }

}

