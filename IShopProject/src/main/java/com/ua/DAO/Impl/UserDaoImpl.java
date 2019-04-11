package com.ua.DAO.Impl;

import com.ua.DAO.DAOs.UserDAO;
import com.ua.Model.User;
import com.ua.Utils.Connector;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDAO {
  private static final String READ_ALL = "SELECT * FROM i_shop.user";
  private static final String READ_BY_ID = "SELECT * FROM i_shop.user WHERE id = ?";
  private static final String INSERT = "INSERT INTO i_shop.user(email, name, surname, role, login, password) values (?, ?, ?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE i_shop.user set email = ?, name = ?, surname = ?, role = ?, login = ?, password = ? WHERE id = ?";
  private static final String DELETE = "DELETE FROM i_shop.user WHERE id = ?";
  private static final String READ_BY_LOGIN = "SELECT * FROM i_shop.user WHERE login = ?";
  
  private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

  private Connection connection;
  private PreparedStatement preparedStatement;

  public UserDaoImpl() {
    try {
		connection = Connector.getConnection();
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
  }
  
  @Override
  public User getUserByLogin(String login) {
   	    String email = null;
	    String name = null;
	    String surname = null;
	    String role = null;
	    String password = null;
	    Integer id = null;
	  try {
		  preparedStatement = connection.prepareStatement(READ_BY_LOGIN);
	      preparedStatement.setString(1, login);
	      ResultSet rs = preparedStatement.executeQuery();
	      rs.next();
	      id = rs.getInt("id");
	      email = rs.getString("email");
	      name = rs.getString("name");
	      surname = rs.getString("surname");
	      role = rs.getString("role");
	      password = rs.getString("password");
	  } catch (SQLException e) {
		  LOGGER.error("Could not find user with such login ", e);
	  }
	  return new User(id, email, name, surname, role, login, password);
  }

  @Override
  public List<User> readAll() {
    List<User> list = new ArrayList<>();
    try {
      preparedStatement = connection.prepareStatement(READ_ALL);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        Integer id = rs.getInt("id");
        String email = rs.getString("email");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String role = rs.getString("role");
        String login = rs.getString("login");
        String password = rs.getString("password");
        list.add(new User(id, email, name, surname, role, login, password));
      }
    } catch (SQLException e){
      LOGGER.error("Fail of the reading users ", e);
    }
      return list;
}

  @Override
  public User create(User obj) {
    try {
      preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, obj.getEmail());
      preparedStatement.setString(2, obj.getName());
      preparedStatement.setString(3, obj.getSurname());
      preparedStatement.setString(4, obj.getRole());
      preparedStatement.setString(5, obj.getLogin());
      preparedStatement.setString(6, obj.getPassword());
      preparedStatement.executeUpdate();
      ResultSet rs = preparedStatement.getGeneratedKeys();
      rs.next();
      obj.setId(rs.getInt(1));
    } catch (SQLException e) {
      LOGGER.error("Fail of the creating user ", e);
    }
    return obj;
  }

  @Override
  public User read(Integer id) {
    String email = null;
    String name = null;
    String surname = null;
    String role = null;
    String login = null;
    String password = null;
    try {
      preparedStatement = connection.prepareStatement(READ_BY_ID);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      rs.next();
      email = rs.getString("email");
      name = rs.getString("name");
      surname = rs.getString("surname");
      role = rs.getString("role");
      login = rs.getString("login");
      password = rs.getString("password");
    } catch (SQLException e) {
      LOGGER.error("Fail of the reading user ", e);
    } 
      return new User(id, email, name, surname, role, login, password);
 }

  @Override
  public User update(User obj) {
    try {
      preparedStatement = connection.prepareStatement(UPDATE);
      preparedStatement.setString(1, obj.getEmail());
      preparedStatement.setString(2, obj.getName());
      preparedStatement.setString(3, obj.getSurname());
      preparedStatement.setString(4, obj.getRole());
      preparedStatement.setInt(5, obj.getId());
    } catch (SQLException e) {
      LOGGER.error("Fail of the updating user ", e);
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
      LOGGER.error("Fail of the deleting user ", e);
    }
  }
}
