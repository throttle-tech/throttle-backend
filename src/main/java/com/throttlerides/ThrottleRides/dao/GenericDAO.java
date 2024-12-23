package com.throttlerides.ThrottleRides.dao;

import java.util.List;

public interface GenericDAO<T> {
  T findById(Long id);
  List<T> findAll();
  Long save(T entity);
  int update(T entity);
  int delete(Long id);
}
