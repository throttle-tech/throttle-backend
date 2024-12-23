--liquibase formatted sql logicalFilePath:db/changelog/throttle-rides-ddl.sql

--changeset slokare:1734986467000

-- Table: users
CREATE TABLE users (
   user_id SERIAL PRIMARY KEY,
   phone_number VARCHAR(15) NOT NULL UNIQUE,
   name VARCHAR(100) NOT NULL,
   email VARCHAR(100) UNIQUE,
   profile_image TEXT,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: rides
CREATE TABLE rides (
   ride_id SERIAL PRIMARY KEY,
   ride_name VARCHAR(200) NOT NULL,
   description TEXT,
   start_time TIMESTAMP NOT NULL,
   end_time TIMESTAMP NOT NULL,
   start_location VARCHAR(255) NOT NULL,
   end_location VARCHAR(255),
   total_slots INTEGER NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: user_rides
CREATE TABLE user_rides (
    user_ride_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(user_id),
    ride_id INTEGER NOT NULL REFERENCES rides(ride_id),
    registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (user_id, ride_id)
);

-- Table: otp_logs
CREATE TABLE otp_logs (
  otp_id SERIAL PRIMARY KEY,
  phone_number VARCHAR(15) NOT NULL,
  otp_code VARCHAR(6) NOT NULL,
  is_verified BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  expires_at TIMESTAMP NOT NULL
);

-- Table: ride_details
CREATE TABLE ride_details (
  detail_id SERIAL PRIMARY KEY,
  ride_id INTEGER NOT NULL REFERENCES rides(ride_id),
  detail_key VARCHAR(100) NOT NULL,
  detail_value TEXT NOT NULL
);

-- Indexes for performance optimization
CREATE INDEX idx_users_phone_number ON users(phone_number);
CREATE INDEX idx_user_rides_user_id_ride_id ON user_rides(user_id, ride_id);
