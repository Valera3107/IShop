package com.ua.Service;

import java.util.Map;

import com.ua.Model.Product;
import com.ua.Shared.AbstractCRUD;

public interface ProductService extends AbstractCRUD<Product> {
	public Map<Integer, Product> readAllMap();

	void delete(Integer id);

	Product read(Integer id);
}
