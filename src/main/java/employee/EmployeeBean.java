package employee;

import java.io.Serializable;

public class EmployeeBean implements Serializable{
private String eid,ename,edesg;
private int bsal;
private float hra,da,totsal;
public EmployeeBean() {}
public String getEid() {
	return eid;
}
public void setEid(String eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEdesg() {
	return edesg;
}
public void setEdesg(String edesg) {
	this.edesg = edesg;
}
public int getBsal() {
	return bsal;
}
public void setBsal(int bsal) {
	this.bsal = bsal;
}
public float getHra() {
	return hra;
}
public void setHra(float hra) {
	this.hra = hra;
}
public float getDa() {
	return da;
}
public void setDa(float da) {
	this.da = da;
}
public float getTotsal() {
	return totsal;
}
public void setTotsal(float totsal) {
	this.totsal = totsal;
}

}
