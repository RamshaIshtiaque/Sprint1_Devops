package com.keyin.controllers;

import com.keyin.models.Airport;
import com.keyin.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
@CrossOrigin(origins = "*") // Allowing all origins for CORS
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.createAirport(airport);
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable Integer id) {
        return airportService.getAirportById(id);
    }

    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable Integer id, @RequestBody Airport airportDetails) {
        return airportService.updateAirport(id, airportDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Integer id) {
        airportService.deleteAirport(id);
    }
}

