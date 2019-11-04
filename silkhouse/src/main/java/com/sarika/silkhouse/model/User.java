package com.sarika.silkhouse.model;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class User{
	int user_type;
	@NotEmpty(message="required")
	private String username;
	@NotEmpty(message="required")
	private String password;
	@NotEmpty(message="required")
	private String mpassword;
	@NotEmpty(message="required")
	private String fname;
	@NotEmpty(message="required")
	private String lname;
	@NotEmpty(message="required")
	private String phone;
	@NotEmpty(message="required")
	private String email;
	
	public User() {
		
	}
	
	public User(String user_id,String pass,String mpass,String fname,String lname,String phone,String email) {
		this.username=user_id;
		this.password=pass;
		this.mpassword=mpass;
		this.fname=fname;
		this.lname=lname;
		this.phone=phone;
		this.email=email;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMpassword() {
		return this.mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	
	
}