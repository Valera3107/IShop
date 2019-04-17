package com.ua.Model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private String description;
	
	@Column
	private Integer amount;

	@Column
	private Double price;

	public Product() {
	}

  public Product(Integer id, String name, String description, Double price, Integer amount) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.amount = amount;
  }

  public Product(String name, String description, Double price, Integer amount) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.amount = amount;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id) &&
      Objects.equals(name, product.name) &&
      Objects.equals(description, product.description) &&
      Objects.equals(price, product.price) &&
      Objects.equals(amount, product.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, price, amount);
  }

  @Override
  public String toString() {
    return "Product{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", description='" + description + '\'' +
      ", price=" + price +
      ", amount=" + amount +
      '}';
  }
}
