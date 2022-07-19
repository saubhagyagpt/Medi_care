package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DbConnection;
import com.entity.Doctor;

@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("email");
		String Pass = request.getParameter("password");
		HttpSession session = request.getSession();
		DoctorDao obj = new DoctorDao(DbConnection.getConnection());
		Doctor doctor = obj.login(Email, Pass);
		if(doctor != null) {
			session.setAttribute("doctObj", doctor);
			response.sendRedirect("doctor/DoctorHome.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Invalid details");
			response.sendRedirect("doctor_login.jsp");
		}
	}

}
