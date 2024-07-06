package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmployeeDAO {
public int k=0;
public int insert(EmployeeBean eb) {
	try {
		Connection con = DBConnection.getCon();
		PreparedStatement pst = con.prepareStatement("insert into employee69 values(?,?,?,?,?,?,?)");
		pst.setString(1, eb.getEid());
		pst.setString(2, eb.getEname());
		pst.setString(3, eb.getEdesg());
		pst.setInt(4, eb.getBsal());
		pst.setFloat(5, eb.getHra());
		pst.setFloat(6, eb.getDa());
		pst.setFloat(7, eb.getTotsal());
		k = pst.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return k;
}
}
