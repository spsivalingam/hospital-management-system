package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InventoryManagerRegisteration
 */
@WebServlet("/InventoryManagerRegisteration")
public class InventoryManagerRegisteration extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		    String uname = request.getParameter("uname");
			String uPassword = request.getParameter("upass");
			String E_first_name = request.getParameter("f_name");
			String E_last_name = request.getParameter("l_name");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String city = request.getParameter("city");
			String z_c = request.getParameter("zip_code");
			int zip_code = Integer.parseInt(z_c);
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String m_n = request.getParameter("mobile_no");
			long mobile_no = Long.parseLong(m_n);
			
			
			Database.add(uname,uPassword,E_last_name, E_first_name, addr1,addr2,city,zip_code,email1,email2,mobile_no);
			Database.addIManager(uname);
		
	}

	
	
}
