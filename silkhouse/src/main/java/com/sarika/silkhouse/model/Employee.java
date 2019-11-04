package com.sarika.silkhouse.model;

//@SuppressWarnings("deprecation")
public class Employee {
	int employee_id;
	//@NotEmpty(message="required")
	//private String material;
	String employee_type;
	String joining_date;
	String name;
	int holiday;
	int salary;
	String adhar_number;

    public int getEmployee_id() {
        return this.employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_type() {
        return this.employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public String getJoining_date() {
        return this.joining_date;
    }

    public void setJoining_date(String joiningdate) {
        this.joining_date = joiningdate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoliday() {
        return this.holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAdhar_number() {
        return this.adhar_number;
    }

    public void setAdhar_number(String adhar_number) {
        this.adhar_number = adhar_number;
    }


	
}
