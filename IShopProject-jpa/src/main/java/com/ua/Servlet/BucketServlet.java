package com.ua.Servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ua.Model.Bucket;
import com.ua.Model.Product;
import com.ua.Model.User;
import com.ua.Service.BucketService;
import com.ua.Service.ProductService;
import com.ua.Service.UserService;
import com.ua.Service.Impl.BucketServiceImpl;
import com.ua.Service.Impl.ProductServiceImpl;
import com.ua.Service.Impl.UserServiceImpl;

@WebServlet("/bucketServlet")
public class BucketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BucketService bucketService = BucketServiceImpl.getBucketService();
    private ProductService productService = ProductServiceImpl.getProductService();
    private UserService userService = UserServiceImpl.getUserService();
    
    public BucketServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		
		Product product = productService.read(Integer.parseInt(productId));
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		User user = userService.read(userId);
		
		
		Bucket bucket = new Bucket();
		bucket.setId(UUID.randomUUID().toString());
		bucket.setProduct(product);
		bucket.setUser(user);
		bucket.setDate(new Date());
		
		bucketService.create(bucket);
		
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String bucketId = req.getParameter("bucketId");
	bucketService.delete(bucketId);
	
	resp.setContentType("text");
	resp.setCharacterEncoding("UTF-8");
	resp.getWriter().write("Success");
	}
}
