package com.throttlerides.ThrottleRides.dao;

import com.throttlerides.ThrottleRides.model.User;

public interface UserDAO extends GenericDAO<User> {
  User findByPhoneNumber(String phoneNumber);
}