package com.ua.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ua.Model.Bucket;
import com.ua.Service.BucketService;
import com.ua.Service.Impl.BucketServiceImpl;

@WebServlet("/bucketServlet")
public class BucketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BucketService bucketService = BucketServiceImpl.getBucketService();
    
    public BucketServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer productId =  Integer.parseInt(request.getParameter("productId"));
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		Bucket bucket = new Bucket(userId, productId, new Date());
		bucketService.create(bucket);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String bucketId = req.getParameter("bucketId");
	bucketService.delete(Integer.parseInt(bucketId));
	
	resp.setContentType("text");
	resp.setCharacterEncoding("UTF-8");
	resp.getWriter().write("Success");
	}
}
