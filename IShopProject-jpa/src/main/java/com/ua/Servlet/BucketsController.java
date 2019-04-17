package com.ua.Servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

import com.google.gson.Gson;
import com.ua.DTO.BucketDTO;
import com.ua.Model.Bucket;
import com.ua.Model.Product;
import com.ua.Service.BucketService;
import com.ua.Service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ua.Service.Impl.BucketServiceImpl;
import com.ua.Service.Impl.ProductServiceImpl;

/**
 * Servlet implementation class BucketsController
 */
@WebServlet("/buckets")
public class BucketsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BucketService bucketService = BucketServiceImpl.getBucketService();
    private ProductService productService = ProductServiceImpl.getProductService();
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		List<Bucket> buckets = bucketService.readAll();
		Map<Integer, Product> idToProduct = productService.readAllMap();
		List<BucketDTO> listOfBucketDTO = mapFunc(buckets, idToProduct);
		
		String json = new Gson().toJson(listOfBucketDTO);
		responce.setContentType("application/json");
		responce.setCharacterEncoding("UTF-8");
		responce.getWriter().write(json);
	}
	
	public List<BucketDTO> mapFunc(List<Bucket> buckets, Map<Integer, Product> idToProduct){
		return	buckets.stream().map(bucket->{
			BucketDTO bucketDTO = new BucketDTO();
			bucketDTO.bucketId = bucket.getId();
			bucketDTO.purchaseDate = bucket.getDate();
		   
			Product product = idToProduct.get(bucket.getProduct().getId());
		    bucketDTO.name = product.getName();
		    bucketDTO.description = product.getDescription();
		    bucketDTO.price = product.getPrice();
			
			return bucketDTO;
		}).collect(Collectors.toList());
		
	}

}
