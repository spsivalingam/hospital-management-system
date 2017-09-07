package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OperatorLogin
 */
@WebServlet("/InventoryManagerLogin")
public class InventoryManagerLogin extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String uPassword = request.getParameter("upass");
	
		
		
		String decision = Database.imCheck(uname,uPassword);
        if (decision == "Exists"){
        	HttpSession session = request.getSession();
           	session.setAttribute("i_user", uname);
           	//System.out.println("session attribute loaded"+session.getAttribute("o_user").toString());
           	
       	response.sendRedirect("InventoryManagerOptions.jsp");
        	
       //response.sendRedirect("employeeRegisteration.html");
		}
        else {
       	 // if the user already exists
        	
        	
        	response.sendRedirect("notReg.html");
       	
       	
       	
       	
        }
		
	}
	

}
