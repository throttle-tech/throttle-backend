package com.throttlerides.ThrottleRides.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideDetail {
  private Long detailId;
  private Long rideId;
  private String detailKey;
  private String detailValue;
}
