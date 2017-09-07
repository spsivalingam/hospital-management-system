package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AptSchedule
 */
@WebServlet("/AptSchedule")
public class AptSchedule extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int pid = Integer.parseInt(request.getParameter("p_id"));
	String doc = request.getParameter("dname");
	String date = request.getParameter("adate");
	int aptHR = Integer.parseInt(request.getParameter("apt_hrs"));
	int aptMin = Integer.parseInt(request.getParameter("apt_min"));
	
	System.out.println("Entered the servlet");
	HttpSession session = request.getSession();
	String op_user = session.getAttribute("o_user").toString();
	
	
	
	int apt_Num = Database.scheduleApt(pid,doc,aptHR,aptMin,op_user,date);
	
	if (apt_Num != 0){
		
	session.setAttribute("apNO", apt_Num);
	
	response.sendRedirect("AptScheduled.jsp");
	}
	else {
		response.sendRedirect("ConflictInSchedule.jsp");
	}
	}

	

}
