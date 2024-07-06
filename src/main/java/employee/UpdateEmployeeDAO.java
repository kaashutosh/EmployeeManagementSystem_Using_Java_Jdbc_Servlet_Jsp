package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateEmployeeDAO {
	public int k=0;
	public int update(EmployeeBean eb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pst = con.prepareStatement("update employee69 set bsal=?,hra=?,da=?,totsal=? where eid=?");
			pst.setInt(1, eb.getBsal());
			pst.setFloat(2, eb.getHra());
			pst.setFloat(3, eb.getDa());
			pst.setFloat(4, eb.getTotsal());
			pst.setString(5, eb.getEid());
			k = pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
