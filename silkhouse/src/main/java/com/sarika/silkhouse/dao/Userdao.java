package com.sarika.silkhouse.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.sarika.silkhouse.model.User;

public interface Userdao{
	@Autowired
	public void saveOrUpdate(User user);
	public void delete(String username);
	public User getUser(String username);
	public User getNumber(String number);
}