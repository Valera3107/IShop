package com.ua.DAO.DAOs;

import com.ua.Model.User;
import com.ua.Shared.AbstractCRUD;

public interface UserDAO extends AbstractCRUD<User> {
	User getUserByLogin(String login);
}
