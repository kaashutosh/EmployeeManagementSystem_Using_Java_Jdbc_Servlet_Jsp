package employee;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view")
public class ViewAllEmployeesServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		} else {
			ArrayList<EmployeeBean> al = new ViewAllEmployeeDAO().retrieve();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllEmployees.jsp").forward(req, res);
		}
	}

}
