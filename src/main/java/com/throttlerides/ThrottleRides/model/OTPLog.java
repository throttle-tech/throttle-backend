package com.throttlerides.ThrottleRides.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OTPLog {
  private Long otpId;
  private String phoneNumber;
  private String otpCode;
  private Boolean isVerified;
  private String createdAt;
  private String expiresAt;
}