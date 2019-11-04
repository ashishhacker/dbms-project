package com.sarika.silkhouse.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.sarika.silkhouse.model.Item;

import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.ui.Model;

import com.sarika.silkhouse.dao.Itemdao;
import com.sarika.silkhouse.model.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ItemdaoImpl implements Itemdao{
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public void deleteItem(int itemId) {
		String sql="delete from products where product_id=\""+itemId+"\"";
		jdbcTemplate.update(sql);
	}
	public List<Item> getAllItems() {
		List<Item> list;
		String sql="select * from ITEMS";
		list=(List<Item>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Item>(Item.class));
		return list;
	}

	@Override
	public Item getItem(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub

	}


}
