package com.ua.DAO.Impl;

import com.ua.DAO.DAOs.BucketDAO;
import com.ua.Model.Bucket;
import com.ua.Utils.Connector;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BucketDAOImpl implements BucketDAO {
  private static final String READ_ALL = "SELECT * FROM i_shop.bucket";
  private static final String READ_BY_ID = "SELECT * FROM i_shop.bucket WHERE id = ?";
  private static final String INSERT = "INSERT INTO i_shop.bucket(user_id, product_id, purchase_date) values (?, ?, ?)";
  private static final String DELETE = "DELETE FROM i_shop.bucket WHERE id = ?";

  private static Logger LOGGER = Logger.getLogger(BucketDAOImpl.class);
  private Connection connection;
  private PreparedStatement preparedStatement;

  public BucketDAOImpl() {
    try {
		connection = Connector.getConnection();
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }

  @Override
  public List<Bucket> readAll() {
    List<Bucket> list = new ArrayList<>();
    try {
      preparedStatement = connection.prepareStatement(READ_ALL);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()){
        Integer bucketId = rs.getInt("id");
        Integer userId = rs.getInt("user_id");
        Integer productId = rs.getInt("product_id");
        Date date = rs.getDate("purchase_date");
        list.add(new Bucket(bucketId, userId, productId, date));
      }
    }catch (SQLException e){
      LOGGER.error("Fail reading of all buckets ", e);
    } 
      return list;
  }

  @Override
  public Bucket create(Bucket obj) {
    try {
      preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setInt(1, obj.getUser_id());
      preparedStatement.setInt(2, obj.getProduct_id()); 
      preparedStatement.setDate(3, new java.sql.Date(obj.getDate().getTime()));
      preparedStatement.executeUpdate();
      System.out.println("gj");
      ResultSet rs = preparedStatement.getGeneratedKeys();
      rs.next();
      
      obj.setId(rs.getInt(1));
    } catch (SQLException e) {
      LOGGER.error("Fail creating of the bucket ", e);
    }
    return obj;
  }

  @Override
  public Bucket read(Integer id) {
    Integer userId = 0;
    Integer productId = 0;
    Date date = null;
    try {
      preparedStatement = connection.prepareStatement(READ_BY_ID);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      rs.next();
      userId = rs.getInt("user_id");
      productId = rs.getInt("product_id");
      date = rs.getDate("purchase_date");
    } catch (SQLException e) {
      LOGGER.error("Fail reading of the bucket ", e);
    }
      return new Bucket(id, userId, productId, date);
  }

  @Override
  public Bucket update(Bucket obj) {
    throw new IllegalStateException("There is no update for bucket!");
  }

  @Override
  public void delete(Integer id) {
    try {
      preparedStatement = connection.prepareStatement(DELETE);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      LOGGER.error("Fail deleting of the bucket ", e);
    }
  }
}
