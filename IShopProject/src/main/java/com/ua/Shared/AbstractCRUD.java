package com.ua.Shared;

import java.util.List;

public interface AbstractCRUD<T> {
  List<T> readAll();

  T create(T obj);

  T read(Integer id);

  T update(T obj);

  void delete(Integer id);
}
