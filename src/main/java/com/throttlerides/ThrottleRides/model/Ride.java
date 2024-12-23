package com.throttlerides.ThrottleRides.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
  private Long rideId;
  private String rideName;
  private String description;
  private String startTime;
  private String endTime;
  private String startLocation;
  private String endLocation;
  private Integer totalSlots;
  private String createdAt;
}
