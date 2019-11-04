package com.sarika.silkhouse.dao;

import java.util.List;

import com.sarika.silkhouse.model.Cart;

public interface Cartdao {
	public void addtocart(int iid,String uid,Cart cart);
	public List<Cart> getcart(String uid);
	public void addquantity(int quantity,int iid,String uid,Cart cart);
	public void deleteItem(int itemId,String uid);
	public int gettotal(String uid);

}
