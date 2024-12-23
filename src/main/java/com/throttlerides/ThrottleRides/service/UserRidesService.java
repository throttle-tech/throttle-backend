package com.throttlerides.ThrottleRides.service;

import com.throttlerides.ThrottleRides.model.UserRides;

import java.util.List;

public interface UserRidesService {
  Long registerUserToRide(Long userId, Long rideId);
  List<UserRides> getUsersByRideId(Long rideId);
}