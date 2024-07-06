package employee;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			EmployeeBean eb = new EmployeeBean();
			eb.setEid(req.getParameter("eid"));
			eb.setEname(req.getParameter("ename"));
			eb.setEdesg(req.getParameter("edesg"));
			int bsal = Integer.parseInt(req.getParameter("bsal"));
			float h = Float.parseFloat(req.getParameter("hra"));
			float d = Float.parseFloat(req.getParameter("da"));
			float hra = (float)(h*bsal)/100;
			float da = (float)(d*bsal)/100;
			float totsal = bsal+hra+d;
			eb.setBsal(bsal);
			eb.setHra(hra);
			eb.setDa(da);
			eb.setTotsal(totsal);
			int k = new AddEmployeeDAO().insert(eb);
			if(k>0) {
				req.setAttribute("msg", "Employee Added Successfully....<br>");
				req.getRequestDispatcher("AddEmployee.jsp").forward(req, res);
			}
			
		}
	}
}
