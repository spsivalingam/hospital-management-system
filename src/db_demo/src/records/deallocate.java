package records;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.Database;

/**
 * Servlet implementation class deallocate
 */
@WebServlet("/deallocate")
public class deallocate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pat_id=request.getParameter("Patient_id");
		String Del ="null";
		 Del = Database.wardBooking(pat_id);
		 
		 if (Del=="success"){
				response.sendRedirect("OperatorOptions.jsp");
			}
			else {
				response.sendRedirect("warddetails.jsp");
			}
	}



}
