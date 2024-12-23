package com.throttlerides.ThrottleRides.dao;


import com.throttlerides.ThrottleRides.model.UserRides;

import java.util.List;

public interface UserRidesDAO extends GenericDAO<UserRides> {
  List<UserRides> findByRideId(Long rideId);
  boolean isUserAlreadyRegistered(Long userId, Long rideId);
}