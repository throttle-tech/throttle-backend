package com.throttlerides.ThrottleRides.dao;

import com.throttlerides.ThrottleRides.model.UserRides;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRidesDAOImpl implements UserRidesDAO {
  private final JdbcTemplate jdbcTemplate;

  public UserRidesDAOImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static final RowMapper<UserRides> USER_RIDES_ROW_MAPPER = (rs, rowNum) -> new UserRides(
          rs.getLong("user_ride_id"),
          rs.getLong("user_id"),
          rs.getLong("ride_id"),
          rs.getString("registered_at")
  );

  @Override
  public UserRides findById(Long id) {
    String sql = "SELECT * FROM user_rides WHERE user_ride_id = ?";
    return jdbcTemplate.queryForObject(sql, USER_RIDES_ROW_MAPPER, id);
  }

  @Override
  public List<UserRides> findAll() {
    String sql = "SELECT * FROM user_rides";
    return jdbcTemplate.query(sql, USER_RIDES_ROW_MAPPER);
  }

  @Override
  public Long save(UserRides userRides) {
    String sql = "INSERT INTO user_rides (user_id, ride_id, registered_at) VALUES (?, ?, CURRENT_TIMESTAMP) RETURNING user_ride_id";
    return jdbcTemplate.queryForObject(sql, Long.class, userRides.getUserId(), userRides.getRideId());
  }

  @Override
  public int update(UserRides userRides) {
    throw new UnsupportedOperationException("Update is not supported for user_rides.");
  }

  @Override
  public int delete(Long id) {
    String sql = "DELETE FROM user_rides WHERE user_ride_id = ?";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public List<UserRides> findByRideId(Long rideId) {
    String sql = "SELECT * FROM user_rides WHERE ride_id = ?";
    return jdbcTemplate.query(sql, USER_RIDES_ROW_MAPPER, rideId);
  }

  @Override
  public boolean isUserAlreadyRegistered(Long userId, Long rideId) {
    String sql = "SELECT COUNT(*) FROM user_rides WHERE user_id = ? AND ride_id = ?";
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class, userId, rideId);
    return count != null && count > 0;
  }
}

