package com.ua.Service.Impl;

import com.ua.DAO.DAOs.UserDAO;
import com.ua.DAO.Impl.UserDaoImpl;
import com.ua.Model.User;
import com.ua.Service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
  private UserDAO userDAO;
  private static UserServiceImpl userService;

  private UserServiceImpl(){
	  userDAO = new UserDaoImpl();
  }

  public static UserServiceImpl getUserService(){
    if(userService == null){
      userService = new UserServiceImpl();
    }

    return userService;
  }
  
  @Override
  public User getUserByLogin(String login) {
	  return userDAO.getUserByLogin(login);
  }

  @Override
  public List<User> readAll() {
    return userDAO.readAll();
  }

  @Override
  public User create(User obj) {
    return userDAO.create(obj);
  }

  @Override
  public User read(Integer id) {
    return userDAO.read(id);
  }

  @Override
  public User update(User obj) {
    return userDAO.update(obj);
  }

  @Override
  public void delete(Integer id) {
    userDAO.delete(id);
  }
}
