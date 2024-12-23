package com.throttlerides.ThrottleRides.dao;

import com.throttlerides.ThrottleRides.model.Ride;

import java.util.List;

public interface RideDAO extends GenericDAO<Ride> {
  List<Ride> findUpcomingRides();
}