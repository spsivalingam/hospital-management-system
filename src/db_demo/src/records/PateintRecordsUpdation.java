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
 * Servlet implementation class PateintRecordsUpdation
 */
@WebServlet("/PateintRecordsUpdation")
public class PateintRecordsUpdation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pid = request.getParameter("pid");
		String doc = request.getParameter("doc");
		String disease = request.getParameter("disease");
		String comments = request.getParameter("comments");
		String viston = request.getParameter("viston");
		String ihrs = request.getParameter("ihrs");
		String imin = request.getParameter("imin");
		String time = ihrs+imin;
		HttpSession session = request.getSession();
		String op_user = session.getAttribute("o_user").toString();
		
		Database.updatePatientRecords(pid,doc,disease,comments,viston,op_user,time);
		response.sendRedirect("OperatorOptions.jsp");
		
	
	}

	
	

}
