package com.ua.Servlet;
import com.ua.Model.User;
import com.ua.Service.Impl.UserServiceImpl;
import com.ua.Service.UserService;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		String role = request.getParameter("role");

		if (!email.isEmpty() && !name.isEmpty() && !surname.isEmpty() && !login.isEmpty() && !password.isEmpty() && !role.isEmpty()) {
	      userService.create(new User(email, name, surname, role, login, password));
		}

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("LoginServlet at :").append(request.getContextPath());
	}
}
