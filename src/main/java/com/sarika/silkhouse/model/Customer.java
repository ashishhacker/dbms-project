package com.sarika.silkhouse.model;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class Customer {
    Long customer_id;
    @NotEmpty(message = "required")
    private String house_number;
    @NotEmpty(message = "required")
    private String pincode;
    @NotEmpty(message = "required")
    private String state;

    public Customer() {

    }

    public Customer(Long customer_id, String house_number, String pincode , String state) {
		this.customer_id=customer_id;
		this. house_number= house_number;
		this.pincode=pincode;
		this.state=state;
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