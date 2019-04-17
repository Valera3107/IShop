package com.ua.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ua.Service.ProductService;
import com.ua.Service.Impl.ProductServiceImpl;
import com.ua.Model.*;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService productService = ProductServiceImpl.getProductService();

	// create method (product)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Double price = Double.parseDouble(req.getParameter("price"));
		Integer amount = Integer.parseInt(req.getParameter("amount"));
		String description = req.getParameter("description");

		Product product = new Product(name, description, price, amount);

		if (product != null && name != "" && amount != 0 && price != 0.0 && description != "") {
			productService.create(product);
			resp.setContentType("text");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write("Success");
		}
	}

	// read method (product)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productId = req.getParameter("id");
		Product product = productService.read(Integer.parseInt(productId));
		req.setAttribute("product", product);
		req.getRequestDispatcher("singleProduct.jsp").forward(req, resp);
	}

	// update method (product)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPut(req, resp);
	}

	// delete method (product)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doDelete(req, resp);
	}

}
