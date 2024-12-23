package com.throttlerides.ThrottleRides.dao;

import com.throttlerides.ThrottleRides.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
  private final JdbcTemplate jdbcTemplate;

  public UserDAOImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static final RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) -> new User(
          rs.getLong("user_id"),
          rs.getString("phone_number"),
          rs.getString("name"),
          rs.getString("email"),
          rs.getString("profile_image"),
          rs.getString("created_at")
  );

  @Override
  public User findById(Long id) {
    String sql = "SELECT * FROM users WHERE user_id = ?";
    return jdbcTemplate.queryForObject(sql, USER_ROW_MAPPER, id);
  }

  @Override
  public List<User> findAll() {
    String sql = "SELECT * FROM users";
    return jdbcTemplate.query(sql, USER_ROW_MAPPER);
  }

  @Override
  public Long save(User user) {
    String sql = "INSERT INTO users (phone_number, name, email, profile_image) VALUES (?, ?, ?, ?) RETURNING user_id";
    return jdbcTemplate.queryForObject(sql, Long.class, user.getPhoneNumber(), user.getName(), user.getEmail(), user.getProfileImage());
  }

  @Override
  public int update(User user) {
    String sql = "UPDATE users SET name = ?, email = ?, profile_image = ? WHERE phone_number = ?";
    return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getProfileImage(), user.getPhoneNumber());
  }

  @Override
  public int delete(Long id) {
    String sql = "DELETE FROM users WHERE user_id = ?";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public User findByPhoneNumber(String phoneNumber) {
    String sql = "SELECT * FROM users WHERE phone_number = ?";
    return jdbcTemplate.queryForObject(sql, USER_ROW_MAPPER, phoneNumber);
  }
}
