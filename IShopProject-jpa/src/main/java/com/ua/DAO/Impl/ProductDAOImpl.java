package com.ua.DAO.Impl;

import com.ua.DAO.DAOs.ProductDAO;
import com.ua.Model.Product;
import com.ua.Utils.Connector;
import com.ua.Utils.FactoryManager;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProductDAOImpl implements ProductDAO {
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Product create(Product product) {
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		try {
			product = em.find(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product update(Product product) {

		try {
			// TODO: to be implemented
		} catch (Exception e) {
		}

		return product;
	}

	@Override
	public void delete(Integer id) {
		try {
			// TODO: to be implemented
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Product e");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
}
