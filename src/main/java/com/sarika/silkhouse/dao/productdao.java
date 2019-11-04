package com.sarika.silkhouse.dao;
import java.util.List;

import com.sarika.silkhouse.model.Item;
public interface productdao {
	public List<Item> getAllItems();

	public List<Item>  getfilterItems(String l);

	public List<Item>  getfilterItems(String l,String m);
	public void save(Item items);
}