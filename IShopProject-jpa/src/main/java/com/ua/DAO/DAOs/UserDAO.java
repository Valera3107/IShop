package com.ua.DAO.DAOs;

import com.ua.Model.Product;
import com.ua.Model.User;
import com.ua.Shared.AbstractCRUD;

public interface UserDAO extends AbstractCRUD<User> {
	User getUserByLogin(String login);

	void delete(Integer id);

	User read(Integer id);
}
