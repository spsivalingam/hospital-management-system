package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/OprRecordDelete")
public class OprRecordDelete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oprUsername = request.getParameter("oprUsername");

		/*
		 * String degree = request.getParameter("degree");
		 * 
		 * String special = request.getParameter("special");
		 * 
		 * String inTimeHrs = request.getParameter("inTimeHr"); int inTimeHrsInt
		 * = Integer.parseInt(inTimeHrs);
		 * 
		 * String inTimeMin = request.getParameter("inTimeMin"); int
		 * inTimeMinInt = Integer.parseInt(inTimeMin);
		 * 
		 * String outTimeHr = request.getParameter("outTimeHr"); int
		 * outTimeHrInt = Integer.parseInt(outTimeHr);
		 * 
		 * String outTimeMin = request.getParameter("outTimeMin"); int
		 * outTimeMinInt = Integer.parseInt(outTimeMin);
		 */

		try {
			// Database.deleteDocRecord(docUsername, degree, special,
			// inTimeHrsInt, inTimeMinInt, outTimeHrInt, outTimeMinInt);
			Database.deleteOprRecord(oprUsername);
			request.getSession().setAttribute("deleteOprMsgSuccess", "Operator's Record Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("deleteOprMsgUnSuccess", "Unable to delete Operator's record");
		}
		response.sendRedirect("	RolesRegisteration.jsp");
	}

}
