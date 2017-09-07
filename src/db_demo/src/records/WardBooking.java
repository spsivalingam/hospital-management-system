package records;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Database;

/**
 * Servlet implementation class WardBooking
 */
@WebServlet("/WardBooking")
public class WardBooking extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bed_num = request.getParameter("bed_num");
		String pat_id=request.getParameter("Patient_id");
		String wardType=request.getParameter("wardType");
		HttpSession session = request.getSession();
		String op_user = session.getAttribute("o_user").toString();
		String Del ="null";
		
			
		
		String Evt = Database.wardBooking(pat_id,op_user,wardType,bed_num);
		
		if (Evt=="success"){
			response.sendRedirect("OperatorOptions.jsp");
		}
		else {
			response.sendRedirect("warddetails.jsp");
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
