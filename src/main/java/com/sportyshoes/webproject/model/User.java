package com.sportyshoes.webproject.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
public class User {
	@Id
	private int uid;
	private String uname;
	private String upassword;
	private Date dateofpurchase;
	private double totalamount;
	private String category;

	public User() {
	}
	

	public User(int uid, String uname, String upassword, Date dateofpurchase, double totalamount, String category) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.dateofpurchase = dateofpurchase;
		this.totalamount = totalamount;
		this.category = category;
	}



	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public Date getDateofpurchase() {
		return dateofpurchase;
	}

	public void setDateofpurchase(Date dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	

}
