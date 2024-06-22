package com.keyin.controllers;

import com.keyin.models.Airport;
import com.keyin.models.City; // Importing the City model
import com.keyin.services.CityService;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@CrossOrigin
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable Integer id) {
        return cityService.getCity(id);
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable Integer id, @RequestBody City cityDetails) {
        return cityService.updateCity(id, cityDetails);
    }


    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Integer id) {
        cityService.deleteCity(id);
    }

    @GetMapping("/{id}/airports")
    public List<Airport> getAirportsInCity(@PathVariable Long id) {
        return cityService.getAirportsInCity(id);
    }


}
