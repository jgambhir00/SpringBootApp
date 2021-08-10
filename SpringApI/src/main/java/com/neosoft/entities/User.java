package com.neosoft.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertable")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	
	private String first_name;
	
	private String last_name;
	
	private String mobile_no;
	
	private String address;
	
	private boolean deleterow;
	
	private Date joiningdate;
	
	
	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String first_name, String last_name, String mobile_no, String address,Date joiningdate) {
		super();
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_no = mobile_no;
		this.address = address;
		this.joiningdate = joiningdate;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getMobile_no() {
		return mobile_no;
	}
	
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void Deleterow( Boolean deleterow) {
		this.deleterow= deleterow;
	}

	public Boolean getDeleterow() {
		return deleterow;
	}

	public void setDeleterow(Boolean deleterow) {
		this.deleterow = deleterow;
	}
}
