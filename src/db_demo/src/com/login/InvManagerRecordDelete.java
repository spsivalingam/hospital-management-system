package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InvManagerRecordDelete")
public class InvManagerRecordDelete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		
		boolean isInvManager = Database.checkInvManager(username);

		if (isInvManager) {

			try {
				// Database.deleteDocRecord(docUsername, degree, special,
				// inTimeHrsInt, inTimeMinInt, outTimeHrInt, outTimeMinInt);
				Database.deleteInvManagerRecord(username);
				request.getSession().setAttribute("deleteOprMsgSuccess", "Operator's Record Deleted");
			} catch (Exception e) {
				e.printStackTrace();
				request.getSession().setAttribute("deleteOprMsgUnSuccess", "Unable to delete Operator's record");
			}
		}else{
			
			request.getSession().setAttribute("updateEmUnSuccess", "Unable to update Lab Incharge record");
		}


		
		response.sendRedirect("	RolesRegisteration.jsp");
	}

}