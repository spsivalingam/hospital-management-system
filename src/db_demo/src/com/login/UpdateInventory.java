package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateInventory")
public class UpdateInventory extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String itemName = request.getParameter("i_name");
		String itemDescription = request.getParameter("i_description");
		String itemQuantity = request.getParameter("i_quantity");
		int item_Quantity = Integer.parseInt(itemQuantity);
		
		
		Boolean redirect = Database.updateInventory(itemName, itemDescription, item_Quantity);;
		
		if (redirect){
			response.sendRedirect("InventoryUpdatedSuccessfully.jsp");
		}
		else
		{
			response.sendRedirect("ItemNotExists.jsp");
		}
	}
	
	
	
	
}
