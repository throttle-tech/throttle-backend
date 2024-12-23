package com.throttlerides.ThrottleRides.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRides {
  private Long userRideId;
  private Long userId;
  private Long rideId;
  private String registeredAt;
}