package com.keyin.controllers;

import com.keyin.models.Passenger;
import com.keyin.models.Aircraft;
import com.keyin.models.Airport;
import com.keyin.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/passengers")
@CrossOrigin(origins = "*") // Allowing all origins for CORS
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public Map<Long, Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {
        return passengerService.getPassengerById(id);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passengerDetails) {
        return passengerService.updatePassenger(id, passengerDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }

    @GetMapping("/{id}/aircrafts")
    public List<Aircraft> getPassengerAircrafts(@PathVariable Long id) {
        return passengerService.getPassengerAircrafts(id);
    }

    @GetMapping("/{id}/airports")
    public List<Airport> getPassengerAirports(@PathVariable Long id) {
        return passengerService.getPassengerAirports(id);
    }
}

