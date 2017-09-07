package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String uPassword= request.getParameter("upass");
		
		String decision = Database.admincheck (uname,uPassword);
		
		if(decision == "Exists"){
			 
			response.sendRedirect("RolesRegisteration.jsp");
			
		}
		else {
			response.sendRedirect("notReg.html");
			
		}
		
	}
	

}
