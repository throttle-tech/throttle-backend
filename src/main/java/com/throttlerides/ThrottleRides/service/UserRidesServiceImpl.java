package com.throttlerides.ThrottleRides.service;

import com.throttlerides.ThrottleRides.dao.RideDAO;
import com.throttlerides.ThrottleRides.dao.UserRidesDAO;
import com.throttlerides.ThrottleRides.model.UserRides;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRidesServiceImpl implements UserRidesService {
  private final UserRidesDAO userRidesDAO;
  private final RideDAO rideDAO;

  public UserRidesServiceImpl(UserRidesDAO userRidesDAO, RideDAO rideDAO) {
    this.userRidesDAO = userRidesDAO;
    this.rideDAO = rideDAO;
  }

  @Override
  public Long registerUserToRide(Long userId, Long rideId) {
    // Check if the ride exists
    rideDAO.findById(rideId);

    // Check if the user is already registered
    if (userRidesDAO.isUserAlreadyRegistered(userId, rideId)) {
      throw new IllegalArgumentException("User is already registered for this ride.");
    }

    // Save the registration
    return userRidesDAO.save(new UserRides(null, userId, rideId, null));
  }

  @Override
  public List<UserRides> getUsersByRideId(Long rideId) {
    return userRidesDAO.findByRideId(rideId);
  }
}
