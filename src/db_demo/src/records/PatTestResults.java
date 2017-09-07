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
 * Servlet implementation class PatTestResults
 */
@WebServlet("/PatTestResults")
public class PatTestResults extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pid = request.getParameter("pid");
		String tname = request.getParameter("tname");
		String tresult = request.getParameter("tresult");
		HttpSession session = request.getSession();
		
		String lname = session.getAttribute("l_name").toString();
		//String lPassword = request.getParameter("lpass");
		Database.addPatTestRecord(pid,tname,tresult,lname);
		
		response.sendRedirect("successAddingResults.html");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
