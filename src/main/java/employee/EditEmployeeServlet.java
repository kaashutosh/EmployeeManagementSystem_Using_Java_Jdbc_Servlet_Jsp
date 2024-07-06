package employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/edit")
public class EditEmployeeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		} else {
			String eld = req.getParameter("eid");
			ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>)hs.getAttribute("alist");
			Iterator<EmployeeBean> itr = al.iterator();
			while(itr.hasNext()) {
				EmployeeBean eb = (EmployeeBean)itr.next();
				if(eld.equals(eb.getEid())) {
					req.setAttribute("ebean", eb);
					break;
				}
			}
			req.getRequestDispatcher("EditEmployee.jsp").forward(req, res);
			
		}
	}
}
