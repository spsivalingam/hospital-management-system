package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmergencyManagerRecdUpdate")
public class EmergencyManagerRecdUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emUsername = request.getParameter("emUsername");

		String lastName = request.getParameter("lastName");

		String firstName = request.getParameter("firstName");

		String addLine1 = request.getParameter("addLine1");

		String addLine2 = request.getParameter("addLine2");

		String city = request.getParameter("city");

		String zipcode = request.getParameter("zipcode");

		String emailAdd1 = request.getParameter("emailAdd1");

		String emailAdd2 = request.getParameter("emailAdd2");

		String mobileNo = request.getParameter("mobileNo");

		boolean isEmManager = Database.checkEmergencyManager(emUsername);

		if (isEmManager) {

			Database.updateEmployeeRecord(emUsername, lastName, firstName, addLine1, addLine2, city, zipcode, emailAdd1,
					emailAdd2, mobileNo);

			response.sendRedirect("RolesRegisteration.jsp");
		}else{
			
			request.getSession().setAttribute("updateEmUnSuccess", "Unable to update Emergency Manager record");
			response.sendRedirect("RolesRegisteration.jsp");
		}
	}

}
