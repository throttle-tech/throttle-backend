package com.throttlerides.ThrottleRides.service;

import com.throttlerides.ThrottleRides.model.Ride;

import java.util.List;

public interface RideService {
  Ride getRideById(Long id);
  List<Ride> getAllRides();
  List<Ride> getUpcomingRides();
  Long createRide(Ride ride);
  void updateRide(Ride ride);
  void deleteRide(Long id);
}
