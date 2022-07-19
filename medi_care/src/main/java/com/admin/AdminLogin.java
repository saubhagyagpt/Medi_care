package com.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String admEmail = request.getParameter("email");
		String admPass = request.getParameter("password"); 
		HttpSession session = request.getSession();
		if("admin@gmail.com".equals(admEmail) && "admin".equals(admPass)) {
			session.setAttribute("admObj", new User());
			response.sendRedirect("admin/AdminHome.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Invalid details");
			response.sendRedirect("admin_login.jsp");
		}
	}

}
