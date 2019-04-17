package com.ua.Service.Impl;

import com.ua.DAO.DAOs.ProductDAO;
import com.ua.DAO.Impl.ProductDAOImpl;
import com.ua.Model.Product;
import com.ua.Service.ProductService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
  private ProductDAO productDAO = new ProductDAOImpl();
  private static ProductServiceImpl productService;

  private ProductServiceImpl() {
  }

  public static ProductServiceImpl getProductService() {
    if (productService == null) {
      productService = new ProductServiceImpl();
    }

    return productService;
  }

  @Override
  public List<Product> readAll() {
    return productDAO.readAll();
  }

  @Override
  public Product create(Product obj) {
    return productDAO.create(obj);
  }

  @Override
  public Product read(Integer id) {
    return productDAO.read(id);
  }

  @Override
  public Product update(Product obj) {
    return productDAO.update(obj);
  }

  @Override
  public void delete(Integer id) {
    productDAO.delete(id);
  }

@Override
public Map<Integer, Product> readAllMap() {
	return readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
}
  
  
}
