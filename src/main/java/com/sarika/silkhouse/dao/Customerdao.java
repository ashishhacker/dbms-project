package com.sarika.silkhouse.dao;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.sarika.silkhouse.model.Profile;

import com.sarika.silkhouse.model.User;

public interface Customerdao {
	@Autowired
	public void addcustomer(Profile customer);
	public List<Profile> getcustomer();
}