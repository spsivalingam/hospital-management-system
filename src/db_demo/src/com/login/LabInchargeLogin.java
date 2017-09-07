package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LabInchargeLogin
 */
@WebServlet("/LabInchargeLogin")
public class LabInchargeLogin extends HttpServlet {
	
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String lname = request.getParameter("lname");
		String lPassword = request.getParameter("lpass");
		
		String decision = Database.labincCheck(lname,lPassword);
        if (decision == null){
       	
        	response.sendRedirect("notReg.html");
       //response.sendRedirect("employeeRegisteration.html");
		}
        else {
       	 // if the user already exists
        	
        	HttpSession session = request.getSession();
        	session.setAttribute("l_name",lname );
        	
       	response.sendRedirect("addTestResults.jsp");
        
	}

	

}
}
