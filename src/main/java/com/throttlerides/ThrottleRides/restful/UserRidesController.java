package com.throttlerides.ThrottleRides.restful;

import com.throttlerides.ThrottleRides.model.UserRides;
import com.throttlerides.ThrottleRides.service.UserRidesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user-rides")
public class UserRidesController {
  private final UserRidesService userRidesService;

  public UserRidesController(UserRidesService userRidesService) {
    this.userRidesService = userRidesService;
  }

  @PostMapping("/register")
  public Long registerUserToRide(@RequestParam Long userId, @RequestParam Long rideId) {
    return userRidesService.registerUserToRide(userId, rideId);
  }

  @GetMapping("/ride/{rideId}")
  public List<UserRides> getUsersByRideId(@PathVariable Long rideId) {
    return userRidesService.getUsersByRideId(rideId);
  }
}
