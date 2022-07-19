package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DbConnection;
import com.entity.User;

@WebServlet("/user_login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Email = request.getParameter("email");
		String Pass = request.getParameter("password");
		HttpSession session = request.getSession();
		UserDao obj = new UserDao(DbConnection.getConnection());
		User u = obj.login(Email, Pass);
		if(u != null) {
			session.setAttribute("userObj", u);
			response.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Invalid details");
			response.sendRedirect("user_login.jsp");
		}
	}

}
