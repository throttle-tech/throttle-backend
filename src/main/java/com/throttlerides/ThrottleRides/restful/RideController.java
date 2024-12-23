package com.throttlerides.ThrottleRides.restful;

import com.throttlerides.ThrottleRides.model.Ride;
import com.throttlerides.ThrottleRides.service.RideService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {
  private final RideService rideService;

  public RideController(RideService rideService) {
    this.rideService = rideService;
  }

  @GetMapping("/{id}")
  public Ride getRideById(@PathVariable Long id) {
    return rideService.getRideById(id);
  }

  @GetMapping
  public List<Ride> getAllRides() {
    return rideService.getAllRides();
  }

  @GetMapping("/upcoming")
  public List<Ride> getUpcomingRides() {
    return rideService.getUpcomingRides();
  }

  @PostMapping
  public Long createRide(@RequestBody Ride ride) {
    return rideService.createRide(ride);
  }

  @PutMapping
  public void updateRide(@RequestBody Ride ride) {
    rideService.updateRide(ride);
  }

  @DeleteMapping("/{id}")
  public void deleteRide(@PathVariable Long id) {
    rideService.deleteRide(id);
  }
}
