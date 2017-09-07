package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DocPersonalDetailUpdate")
public class DocPersonalDetailUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String docUsername = request.getParameter("docUsername");

		String docLastName = request.getParameter("docLastName");

		String docFirstName = request.getParameter("docFirstName");

		String addLine1 = request.getParameter("addLine1");

		String addLine2 = request.getParameter("addLine2");

		String city = request.getParameter("city");

		String zipcode = request.getParameter("zipcode");

		String emailAdd1 = request.getParameter("emailAdd1");

		String emailAdd2 = request.getParameter("emailAdd2");

		String mobileNo = request.getParameter("mobileNo");

		
			Database.updateDocPerRecord(docUsername, docLastName, docFirstName, addLine1, addLine2, city, zipcode,
					emailAdd1, emailAdd2, mobileNo);
		
		
		response.sendRedirect("RolesRegisteration.jsp");
	}

}
