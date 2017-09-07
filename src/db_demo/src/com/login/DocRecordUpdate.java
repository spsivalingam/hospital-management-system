package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DocRecordUpdate")
public class DocRecordUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String docUsername = request.getParameter("docUsername");

		String degree = request.getParameter("degree");

		String special = request.getParameter("special");

		/*String inTimeHrs = request.getParameter("inTimeHr");
		int inTimeHrsInt = Integer.parseInt(inTimeHrs);
		
		String inTimeMin = request.getParameter("inTimeMin");
		int inTimeMinInt = Integer.parseInt(inTimeMin);
		
		String outTimeHr = request.getParameter("outTimeHr");
		int outTimeHrInt = Integer.parseInt(outTimeHr);
		
		String outTimeMin = request.getParameter("outTimeMin");
		int outTimeMinInt = Integer.parseInt(outTimeMin);*/

		try{
		/*Database.updateDocRecord(docUsername, degree, special, inTimeHrsInt, inTimeMinInt, outTimeHrInt, outTimeMinInt);
		request.getSession().setAttribute("updateMsgSuccess", "Doctor's Record Updated");*/
			
		Database.updateDocRecord(docUsername, degree, special);
			request.getSession().setAttribute("updateMsgSuccess", "Doctor's Record Updated");
		}catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("updateMsgUnSuccess", "Unable to update Doctor's record");
		}
		response.sendRedirect("	RolesRegisteration.jsp");
	}

}