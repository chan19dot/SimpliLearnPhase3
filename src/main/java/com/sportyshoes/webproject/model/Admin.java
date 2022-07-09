package com.sportyshoes.webproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admindetails")
public class Admin {
	
	@Id
	private int adminid;
	private String adminname;
	private String adminpass;
	
	public Admin() {
	}
	
	public Admin(int adminid, String adminname, String adminpass) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.adminpass = adminpass;
	}
	
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	
}
