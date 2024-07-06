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

@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String eld = req.getParameter("eid");
			int bs = Integer.parseInt(req.getParameter("bsal"));
			float h = Float.parseFloat(req.getParameter("hra"));
			float d = Float.parseFloat(req.getParameter("da"));
			float hra = (float)(h*bs)/100;
			float da = (float)(d*bs)/100;
			float tots = bs+hra+da;
			ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>)hs.getAttribute("alist");
			Iterator<EmployeeBean> itr = al.iterator();
			while(itr.hasNext()) {
				EmployeeBean eb = (EmployeeBean)itr.next();
				if(eld.equals(eb.getEid())) {
					eb.setBsal(bs);
					eb.setHra(hra);
					eb.setDa(da);
					eb.setTotsal(tots);
					int k = new UpdateEmployeeDAO().update(eb);
					if(k>0) {
						req.setAttribute("msg", "Employee Updated successfully....<br>");
					}
					break;
				}
			}
			req.getRequestDispatcher("UpdateEmployee.jsp").forward(req, res);
		}
	}
}
