package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDAO;
import com.db.DbConnection;
import com.entity.Appointment;
@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.println("hello");
		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appoint_date = req.getParameter("appoint_date");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String diseases = req.getParameter("diseases");
		int doctor_id = Integer.parseInt(req.getParameter("doct"));
		String address = req.getParameter("address");
		//setting the content type  
		//get the stream to write the data  
		  
		 System.out.print(userId);
		 System.out.print(fullname);
		 System.out.print(gender);
		 System.out.print(age);
		 
		pw.println(userId);  
		pw.println("hello");
		Appointment  ap = new Appointment(userId,fullname,gender,age,appoint_date,email,phone,doctor_id,address,"pending",diseases);
		
		AppointmentDAO dao = new AppointmentDAO(DbConnection.getConnection());
		 HttpSession session = req.getSession();
		 if(dao.addAppointment(ap)) {
			 session.setAttribute("succMsg", "Appointment Successfully");
			 resp.sendRedirect("Appointment.jsp");
		 }
		 else {
			 session.setAttribute("errorMsg", "Something wrong on server");
			 resp.sendRedirect("Appointment.jsp");
		 }
	}

}
