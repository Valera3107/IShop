package com.ua.Shared;

import java.util.List;

public interface AbstractCRUD<T> {
  List<T> readAll();

  T create(T obj);

  T update(T obj);

}
