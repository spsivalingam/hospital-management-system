package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteInventory")
public class DeleteInventory extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String itemName = request.getParameter("i_name");
		
		
		Boolean redirect = Database.deleteInventory(itemName);
		
		if (redirect){
			response.sendRedirect("InventoryDeletedSuccessfully.jsp");
		}
		else
		{
			response.sendRedirect("ItemNotExists.jsp");
		}
	}
	
	
	
	
	
	
	
}
