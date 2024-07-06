package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewAllEmployeeDAO {
	public ArrayList<EmployeeBean> al = new ArrayList<EmployeeBean>();
	public ArrayList<EmployeeBean> retrieve(){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pst = con.prepareStatement("select * from Employee69");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				EmployeeBean eb = new EmployeeBean();
				eb.setEid(rs.getString(1));
				eb.setEname(rs.getString(2));
				eb.setEdesg(rs.getString(3));
				eb.setBsal(rs.getInt(4));
				eb.setHra(rs.getFloat(5));
				eb.setDa(rs.getFloat(6));
				eb.setTotsal(rs.getFloat(7));
				al.add(eb);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
