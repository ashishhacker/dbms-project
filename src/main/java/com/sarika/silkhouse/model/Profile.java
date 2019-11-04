package com.sarika.silkhouse.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class Profile {
     int employee_id;
    @NotNull(message="required")
     private int employee_type;
     int profile_id;
	@NotEmpty(message="required")
	private String joining_date;
	private int  holiday;
	@NotNull(message="required")
	private Long salary;
	@NotEmpty(message="required")
	private String adhar_number;
	@NotEmpty(message="required")
    private String fname;
    @NotEmpty(message="required")
    private String lname;
    @NotEmpty(message="required")
    private String phone1;
    private int profile_type;
    String phone2;
    @NotEmpty(message="required")
    private String email;
    Long customer_id;
    @NotEmpty(message = "required")
    private String house_number;
    @NotEmpty(message = "required")
    private String pincode;
    @NotEmpty(message = "required")
    private String state;
    public Profile(){};
    
    public Profile(String house_number,String pincode,String state,String fname, String lname, String phone1,String phone2,String email) {
        this.house_number=house_number;
        this.pincode=pincode;
        this.email=email;
        this.fname=fname;
        this.lname=lname;
        this.state=state;
        this.phone1=phone1;
        this.phone2=phone2;
	}
    public Profile(int employee_type,String joining_date,Long salary,String adhar_number,String fname, String lname, String phone1,String phone2,String email) {
        this.adhar_number=adhar_number;
        this.employee_type=employee_type;
        this.email=email;
        this.fname=fname;
        this.lname=lname;
        this.joining_date=joining_date;
        this.phone1=phone1;
        this.phone2=phone2;
        this.salary=salary;
	}

    
    public int getEmployee_id() {
        return this.employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getEmployee_type() {
        return this.employee_type;
    }

    public void setEmployee_type(int employee_type) {
        this.employee_type = employee_type;
    }

    public int getProfile_id() {
        return this.profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getJoining_date() {
        return this.joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }

    public int getHoliday() {
        return this.holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }

    public Long getSalary() {
        return this.salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getAdhar_number() {
        return this.adhar_number;
    }

    public void setAdhar_number(String adhar_number) {
        this.adhar_number = adhar_number;
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

    public String getPhone1() {
        return this.phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public int getProfile_type() {
        return this.profile_type;
    }

    public void setProfile_type(int profile_type) {
        this.profile_type = profile_type;
    }

    public String getPhone2() {
        return this.phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }




}