package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CanAppointment
 */
@WebServlet("/CanAppointment")
public class CanAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String patid = request.getParameter("p_id");
		int pat_id = Integer.parseInt(patid);
		String dname = request.getParameter("dname");
		String app_date = request.getParameter("appdate");
		HttpSession sess = request.getSession();
		String appno = sess.getAttribute("o_appno").toString();
		
		Boolean redirect = Database.canapp(appno,pat_id,dname,app_date);
		
		if (redirect){
			response.sendRedirect("patientRegSuccessfully.html");
		}
	}
}
