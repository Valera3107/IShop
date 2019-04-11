package com.ua.Service.Impl;

import com.ua.DAO.DAOs.BucketDAO;
import com.ua.DAO.Impl.BucketDAOImpl;
import com.ua.Model.Bucket;
import com.ua.Service.BucketService;

import java.util.List;

public class BucketServiceImpl implements BucketService {
  private BucketDAO bucketDAO = new BucketDAOImpl();
  private static BucketServiceImpl bucketService;

  private BucketServiceImpl() {
  }

  public static BucketServiceImpl getBucketService() {
    if (bucketService == null) {
      bucketService = new BucketServiceImpl();
    }

    return bucketService;
  }

  @Override
  public List<Bucket> readAll() {
    return bucketDAO.readAll();
  }

  @Override
  public Bucket create(Bucket obj) {
    return bucketDAO.create(obj);
  }

  @Override
  public Bucket read(Integer id) {
    return bucketDAO.read(id);
  }

  @Override
  public Bucket update(Bucket obj) {
    return bucketDAO.update(obj);
  }

  @Override
  public void delete(Integer id) {
    bucketDAO.delete(id);
  }
}
