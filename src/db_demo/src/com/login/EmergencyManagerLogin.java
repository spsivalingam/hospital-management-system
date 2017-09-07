package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmergencyManagerLogin")
public class EmergencyManagerLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String uPassword= request.getParameter("upass");
		
		String decision = Database.emerManagercheck (uname,uPassword);
		
		if(decision == "Exists"){
			 
			response.sendRedirect("Emoptions.jsp");
			
		}
		else {
			response.sendRedirect("notReg.html");
			
		}
		
	}
	

}
