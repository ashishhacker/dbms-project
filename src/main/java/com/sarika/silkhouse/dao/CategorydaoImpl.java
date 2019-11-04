package com.sarika.silkhouse.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sarika.silkhouse.model.Category;
import com.sarika.silkhouse.model.Location;
import com.sarika.silkhouse.model.User;

@Repository
@Transactional
public class CategorydaoImpl implements Categorydao {
	@Autowired
	private DataSource datasource;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Category> getallcat() {
		// TODO Auto-generated method stub
		List<Category> list;
		String sql="select * from products order by product_id";
		list=(List<Category>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
		return list;
	}
	
	@Override
	public void addCat(Category category) {
		// TODO Auto-generated method stub
		String sql="insert into category set cname=?";
		Object[] object= {category.getCname()};
		jdbcTemplate.update(sql,object);
	}
	@Override
	public List<User> getallusers() {
		// TODO Auto-generated method stub
		List<User> list;
		String sql="select * from user order by username";
		list=(List<User>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return list;
	}
	

}
