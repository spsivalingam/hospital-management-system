package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String uPassword = request.getParameter("upass");
		
		String decision = Database.doctorCheck(uname,uPassword);
        if (decision == null){
       	
        	response.sendRedirect("notReg.html");
       //response.sendRedirect("employeeRegisteration.html");
		}
        else {
       	 // if the user already exists
        	HttpSession session = request.getSession();
           	session.setAttribute("d_user", uname);
        	response.sendRedirect("DoctorOptions.jsp");
        }
		
	}
	

}
