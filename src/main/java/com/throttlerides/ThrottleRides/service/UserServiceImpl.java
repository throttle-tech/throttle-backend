package com.throttlerides.ThrottleRides.service;

import com.throttlerides.ThrottleRides.dao.UserDAO;
import com.throttlerides.ThrottleRides.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private final UserDAO userDAO;

  public UserServiceImpl(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @Override
  public User getUserById(Long id) {
    return userDAO.findById(id);
  }

  @Override
  public List<User> getAllUsers() {
    return userDAO.findAll();
  }

  @Override
  public User getUserByPhoneNumber(String phoneNumber) {
    return userDAO.findByPhoneNumber(phoneNumber);
  }

  @Override
  public Long createUser(User user) {
    return userDAO.save(user);
  }

  @Override
  public void updateUser(User user) {
    userDAO.update(user);
  }

  @Override
  public void deleteUser(Long id) {
    userDAO.delete(id);
  }
}
