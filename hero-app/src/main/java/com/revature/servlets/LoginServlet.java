package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.AuthenticationService;

public class LoginServlet extends HttpServlet {
	
	public void init() {
		System.out.println("Login Servlet Ready To Go!");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.html").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (AuthenticationService.isValidUser(username, password)) {
			System.out.println("valid user");
			session.setAttribute("username", username);
			session.setAttribute("problem", null);
			response.sendRedirect("/hero-app/app/hero/go");
		} else {
			System.out.println("invalid user");
			session.setAttribute("problem", "incorrect login");
			response.sendRedirect("/hero-app/login");
		}
	}

}
