package com.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DbConnection;
@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		DoctorDao dao = new DoctorDao(DbConnection.getConnection());
		HttpSession session = req.getSession();

		if (dao.deleteDoctor(id)) {
			session.setAttribute("succMsg", "Doctor Deleted Sucessfully..");
			resp.sendRedirect("admin/ViewDoctor.jsp");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("admin/ViewDoctor.jsp");
		}

	} 

}
