package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdatePatientRecords
 */
@WebServlet("/UpdatePatientRecords")
public class UpdatePatientRecords extends HttpServlet {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p_id = request.getParameter("pid");
		
		String decision = Database.patientIDCheck(p_id);
        if (decision == "Exists"){
        	HttpSession session = request.getSession();
           	session.setAttribute("o_pid", p_id);
           	//System.out.println("session attribute loaded"+session.getAttribute("o_user").toString());
           	
       	response.sendRedirect("PatientPersonalRecUpd.jsp");
        	
       //response.sendRedirect("employeeRegisteration.html");
		}
        else {
       	 // if the user already exists
        	     	
         	response.sendRedirect("notReg.html");       	
        }
		
	}

}
