package com.ua.Service;

import com.ua.Model.User;
import com.ua.Shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
	User getUserByLogin(String login);
	
	void delete(Integer id);

	User read(Integer id);
}
