package com.sarika.silkhouse.dao;

import com.sarika.silkhouse.model.Employee;
import com.sarika.silkhouse.model.Profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import com.sarika.silkhouse.model.User;

public interface Employeedao{
	@Autowired
	public List<Employee> getall();
	public void delete(int eid);
	public void update(int quantity,int eid);
	public void save(Profile profile);
}