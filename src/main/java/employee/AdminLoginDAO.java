package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO {
	public AdminBean ab = null;
	public AdminBean Login(String uN,String pW) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pst = con.prepareStatement("select * from EmpAdmin59 where uname=? and pword=?");
			pst.setString(1, uN);
			pst.setString(2, pW);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				ab = new AdminBean();
				ab.setUname(rs.getString(1));
				ab.setPword(rs.getString(2));
				ab.setFname(rs.getString(3));
				ab.setLname(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setMid(rs.getString(6));
				ab.setPhno(rs.getLong(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ab;
	}

}
