package com.keyin.controllers;

import com.keyin.models.Aircraft;
import com.keyin.models.Airport;
import com.keyin.models.Passenger;
import com.keyin.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aircraft")
@CrossOrigin(origins = "*") // Allowing all origins for CORS
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @GetMapping
    public Map<Long, Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.createAircraft(aircraft);
    }

    @GetMapping("/{id}")
    public Aircraft getAircraftById(@PathVariable Long id) {
        return aircraftService.getAircraftById(id);
    }

    @PutMapping("/{id}")
    public Aircraft updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraftDetails) {
        return aircraftService.updateAircraft(id, aircraftDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
    }

    @GetMapping("/{id}/airports")
    public List<Airport> getAircraftAirports(@PathVariable Long id) {
        return aircraftService.getAircraftAirports(id);
    }

    @GetMapping("/{id}/passengers")
    public List<Passenger> getAircraftPassengers(@PathVariable Long id) {
        return aircraftService.getAircraftPassengers(id);
    }
}

