package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/handlingRequests")
public class HandlingRequests extends HttpServlet{

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String request_id = request.getParameter("request_id");
		String doctor_id = request.getParameter("doctor_id");
		String item_name = request.getParameter("item_name");
		String requiredQuantity = request.getParameter("requiredQuantity");
		int requiredQuantity1 = Integer.parseInt(requiredQuantity);
		System.out.println("requiredQuantity: " +requiredQuantity1);
		String availableQuantity = request.getParameter("availableQuantity");
		int availableQuantity1 = Integer.parseInt(availableQuantity);
		System.out.println("availableQuantity: "+availableQuantity1);
		String Accept = request.getParameter("Accept");
		
		String Reject = request.getParameter("Reject");
		
		if(Accept!=null)
		{
			if(availableQuantity1>=requiredQuantity1 && requiredQuantity1!=0)
			{
				Database.AcceptInventoryRequest(request_id, doctor_id, item_name, requiredQuantity1, availableQuantity1);
				response.sendRedirect("RequestAccepted.jsp");
			}
			else
			{
				Database.RejectInventoryRequest(request_id, doctor_id, item_name, requiredQuantity1, availableQuantity1);
				response.sendRedirect("RequestNotAccepted.jsp");
			}
			
		}
		else if(Reject!=null)
		{
			Database.RejectInventoryRequest(request_id, doctor_id, item_name, requiredQuantity1, availableQuantity1);
			response.sendRedirect("RequestReject.jsp");
			
		}
		
		
	}
	
	
	
	
	
	
	
}
