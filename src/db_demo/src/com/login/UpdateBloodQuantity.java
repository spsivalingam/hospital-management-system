package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateBloodQuantity")
public class UpdateBloodQuantity extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bloodgroup = request.getParameter("bloodgroup");
		String bg_quantity = request.getParameter("bg_quantity");
		
		int bgQuantity = Integer.parseInt(bg_quantity);
		
		
		Boolean redirect = Database.updateBloodQuantity(bloodgroup,bgQuantity);;
		
		if (redirect){
			response.sendRedirect("BloodQuantityUpdatedSuccess.jsp");
		}
		else
		{
			response.sendRedirect("BloodGroupNotExists.jsp");
		}
	}
}
