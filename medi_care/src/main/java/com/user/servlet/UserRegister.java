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
@WebServlet("/user_register")
public class UserRegister extends  HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User u = new User(name, email,password);
			UserDao dao = new UserDao(DbConnection.getConnection());
			HttpSession session = request.getSession();
			boolean res = dao.userRegister(u);
			if(res) {
				session.setAttribute("succMsg", "Register Sucessfully");
				response.sendRedirect("signup.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Something went wrong");
				response.sendRedirect("signup.jsp");
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}

}
