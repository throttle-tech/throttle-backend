package com.throttlerides.ThrottleRides.service;

import com.throttlerides.ThrottleRides.dao.RideDAO;
import com.throttlerides.ThrottleRides.model.Ride;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideServiceImpl implements RideService {
  private final RideDAO rideDAO;

  public RideServiceImpl(RideDAO rideDAO) {
    this.rideDAO = rideDAO;
  }

  @Override
  public Ride getRideById(Long id) {
    return rideDAO.findById(id);
  }

  @Override
  public List<Ride> getAllRides() {
    return rideDAO.findAll();
  }

  @Override
  public List<Ride> getUpcomingRides() {
    return rideDAO.findUpcomingRides();
  }

  @Override
  public Long createRide(Ride ride) {
    return rideDAO.save(ride);
  }

  @Override
  public void updateRide(Ride ride) {
    rideDAO.update(ride);
  }

  @Override
  public void deleteRide(Long id) {
    rideDAO.delete(id);
  }
}
