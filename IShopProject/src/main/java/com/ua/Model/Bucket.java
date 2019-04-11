package com.ua.Model;

import java.util.Date;
import java.util.Objects;

public class Bucket {
  private Integer id;
  private Integer user_id;
  private Integer product_id;
  private Date date;

  public Bucket(Integer id, Integer user_id, Integer product_id, Date date) {
    this.id = id;
    this.user_id = user_id;
    this.product_id = product_id;
    this.date = date;
  }

  public Bucket(Integer user_id, Integer product_id, Date date) {
    this.user_id = user_id;
    this.product_id = product_id;
    this.date = date;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }

  public Integer getProduct_id() {
    return product_id;
  }

  public void setProduct_id(Integer product_id) {
    this.product_id = product_id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bucket bucket = (Bucket) o;
    return id.equals(bucket.id) &&
      user_id.equals(bucket.user_id) &&
      product_id.equals(bucket.product_id) &&
      date.equals(bucket.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, user_id, product_id, date);
  }

  @Override
  public String toString() {
    return "Bucket{" +
      "id=" + id +
      ", user_id=" + user_id +
      ", product_id=" + product_id +
      ", date=" + date +
      '}';
  }
}
