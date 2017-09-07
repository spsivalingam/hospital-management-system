package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PlaceRequest")
public class PlaceRequest extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        String doctor_name = session.getAttribute("d_user").toString();

		String item_name = request.getParameter("i_name");
		String quantity = request.getParameter("i_quantity");
		int i_quantity = Integer.parseInt(quantity);
		
		
		int j = Database.addRequestForInventory(doctor_name, item_name, i_quantity);
		if(j==1)
		{
			response.sendRedirect("RequestPlacedSuccessfully.jsp");
		}
		else if(j==0)
		{
			response.sendRedirect("RequestNotPlacedSuccessfully.jsp");
		}
		
	}

	
	
	
	
	
	
	
}
