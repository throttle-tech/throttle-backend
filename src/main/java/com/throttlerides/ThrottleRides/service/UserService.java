package com.throttlerides.ThrottleRides.service;

import com.throttlerides.ThrottleRides.model.User;

import java.util.List;

public interface UserService {
  User getUserById(Long id);
  List<User> getAllUsers();
  User getUserByPhoneNumber(String phoneNumber);
  Long createUser(User user);
  void updateUser(User user);
  void deleteUser(Long id);
}