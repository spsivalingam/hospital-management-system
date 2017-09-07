package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocWorkinghrs
 */
@WebServlet("/DocWorkinghrs")
public class DocWorkinghrs extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String duName = request.getParameter("duname");
		
		String iHrs = request.getParameter("ihrs");
		int inHrs= Integer.parseInt(iHrs);
		
		String imin = request.getParameter("imin");
		int inMin= Integer.parseInt(imin);
		
		String ohrs = request.getParameter("ohrs");
		int oHrs= Integer.parseInt(ohrs);
		
		String omin = request.getParameter("omin");
		int oMin= Integer.parseInt(omin);
		
		
		Database.upWrkHrs(duName,inHrs,inMin,oHrs,oMin);
		response.sendRedirect("ListOfDoctorVistingHours.jsp");
		}

	
	

}
