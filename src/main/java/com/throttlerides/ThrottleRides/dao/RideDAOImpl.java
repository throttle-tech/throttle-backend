package com.throttlerides.ThrottleRides.dao;

import com.throttlerides.ThrottleRides.model.Ride;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RideDAOImpl implements RideDAO {
  private final JdbcTemplate jdbcTemplate;

  public RideDAOImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static final RowMapper<Ride> RIDE_ROW_MAPPER = (rs, rowNum) -> new Ride(
          rs.getLong("ride_id"),
          rs.getString("ride_name"),
          rs.getString("description"),
          rs.getString("start_time"),
          rs.getString("end_time"),
          rs.getString("start_location"),
          rs.getString("end_location"),
          rs.getInt("total_slots"),
          rs.getString("created_at")
  );

  @Override
  public Ride findById(Long id) {
    String sql = "SELECT * FROM rides WHERE ride_id = ?";
    return jdbcTemplate.queryForObject(sql, RIDE_ROW_MAPPER, id);
  }

  @Override
  public List<Ride> findAll() {
    String sql = "SELECT * FROM rides";
    return jdbcTemplate.query(sql, RIDE_ROW_MAPPER);
  }

  @Override
  public Long save(Ride ride) {
    String sql = "INSERT INTO rides (ride_name, description, start_time, end_time, start_location, end_location, total_slots) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING ride_id";
    return jdbcTemplate.queryForObject(sql, Long.class, ride.getRideName(), ride.getDescription(), ride.getStartTime(),
            ride.getEndTime(), ride.getStartLocation(), ride.getEndLocation(), ride.getTotalSlots());
  }

  @Override
  public int update(Ride ride) {
    String sql = "UPDATE rides SET ride_name = ?, description = ?, start_time = ?, end_time = ?, " +
            "start_location = ?, end_location = ?, total_slots = ? WHERE ride_id = ?";
    return jdbcTemplate.update(sql, ride.getRideName(), ride.getDescription(), ride.getStartTime(),
            ride.getEndTime(), ride.getStartLocation(), ride.getEndLocation(), ride.getTotalSlots(), ride.getRideId());
  }

  @Override
  public int delete(Long id) {
    String sql = "DELETE FROM rides WHERE ride_id = ?";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public List<Ride> findUpcomingRides() {
    String sql = "SELECT * FROM rides WHERE start_time > CURRENT_TIMESTAMP";
    return jdbcTemplate.query(sql, RIDE_ROW_MAPPER);
  }
}
