package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminLogin
 */
@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String uPassword = request.getParameter("upass");
		
		String decision = Database.check (uname,uPassword);
        if (decision == null){
       	
        	response.sendRedirect("notReg.html");
       //response.sendRedirect("employeeRegisteration.html");
		}
        else {
       	 // if the user already exists
        	
        	
        	
       	response.sendRedirect("RolesRegisteration.jsp");
        }
		
	}

	
	

}
