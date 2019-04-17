package com.ua.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "bucket")
public class Bucket {

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	@Column(name = "purchase_date")
	private Date date;

	public Bucket() {
	}

  public Bucket(String id, User user, Product product, Date date) {
    this.id = id;
    this.user = user;
    this.product = product;
    this.date = date;
  }

  public Bucket(User user, Product product, Date date) {
    this.user = user;
    this.product = product;
    this.date = date;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
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
      user.equals(bucket.user) &&
      product.equals(bucket.product) &&
      date.equals(bucket.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, user, product, date);
  }

  @Override
  public String toString() {
    return "Bucket{" +
      "id=" + id +
      ", user_id=" + user +
      ", product_id=" + product +
      ", date=" + date +
      '}';
  }
}
