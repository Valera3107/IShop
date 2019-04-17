package com.ua.DAO.DAOs;

import com.ua.Model.Product;
import com.ua.Shared.AbstractCRUD;

public interface ProductDAO extends AbstractCRUD<Product> {
	void delete(Integer id);
	
	Product read(Integer id);
}
