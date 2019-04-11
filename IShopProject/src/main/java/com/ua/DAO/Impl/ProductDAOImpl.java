package com.ua.DAO.Impl;

import com.ua.DAO.DAOs.ProductDAO;
import com.ua.Model.Product;
import com.ua.Utils.Connector;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
  private static final String READ_ALL = "SELECT * FROM i_shop.product";
  private static final String READ_BY_ID = "SELECT * FROM i_shop.product WHERE id = ?";
  private static final String INSERT = "INSERT INTO i_shop.product(name, description, price, amount) values (?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE i_shop.product set name = ?, description = ?, price = ?, amount = ? WHERE id = ?";
  private static final String DELETE = "DELETE FROM i_shop.product WHERE id = ?";

  private static Logger LOGGER = Logger.getLogger(ProductDAOImpl.class);

  private Connection connection;
  private PreparedStatement preparedStatement;

  public ProductDAOImpl() {
    try {
		connection = Connector.getConnection();
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
  }

  @Override
  public List<Product> readAll() {
    List<Product> list = new ArrayList<>();
    try {
      preparedStatement = connection.prepareStatement(READ_ALL);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        Double price = rs.getDouble("price");
        Integer amount = rs.getInt("amount");
        list.add(new Product(id, name, description, price, amount));
      }
    } catch (SQLException e){
      LOGGER.error("Fail of the reading products ", e);
    }
    System.out.println(list);
      return list;
}

  @Override
  public Product create(Product obj) {
    try {
      preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, obj.getName());
      preparedStatement.setString(2, obj.getDescription());
      preparedStatement.setDouble(3, obj.getPrice());
      preparedStatement.setInt(4, obj.getAmount());
      preparedStatement.executeUpdate();
      ResultSet rs = preparedStatement.getGeneratedKeys();
      rs.next();
      obj.setId(rs.getInt(1));
    } catch (SQLException e) {
      LOGGER.error("Fail of the creating product ", e);
    }
    return obj;
  }

  @Override
  public Product read(Integer id) {
    String name = null;
    String discription = null;
    Double price = null;
    Integer amount = null;
    try {
      preparedStatement = connection.prepareStatement(READ_BY_ID);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      rs.next();
      name = rs.getString("name");
      discription = rs.getString("description");
      System.out.println(discription);
      price = rs.getDouble("price");
      amount = rs.getInt("amount");
    } catch (SQLException e) {
      LOGGER.error("Fail of the reading product ", e);
    } 
      return new Product(id, name, discription, price, amount); 
}

  @Override
  public Product update(Product obj) {
    try {
      preparedStatement = connection.prepareStatement(UPDATE);
      preparedStatement.setString(1, obj.getName());
      preparedStatement.setString(2, obj.getDescription());
      preparedStatement.setDouble(3, obj.getPrice());
      preparedStatement.setInt(4, obj.getAmount());
      preparedStatement.setInt(5,obj.getId());
    } catch (SQLException e) {
      LOGGER.error("Fail of the updating product ", e);
    }
    return obj;
  }

  @Override
  public void delete(Integer id) {
    try {
      preparedStatement = connection.prepareStatement(DELETE);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      LOGGER.error("Fail of the deleting product ", e);
    }
  }

}
