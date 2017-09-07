package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CanApt
 */
@WebServlet("/CanApt")
public class CanApt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String app_no = request.getParameter("appno");
		
		String decision = Database.appNoCheck(app_no);
        if (decision == "Exists"){
        	HttpSession session = request.getSession();
           	session.setAttribute("o_appno", app_no);
           	//System.out.println("session attribute loaded"+session.getAttribute("o_user").toString());
           	
       	response.sendRedirect("CanAppointment.jsp");
        	
       //response.sendRedirect("employeeRegisteration.html");
		}
        else {
       	 // if the user already exists
        	     	
         	response.sendRedirect("notReg.html");       	
        }
		
	}

}
