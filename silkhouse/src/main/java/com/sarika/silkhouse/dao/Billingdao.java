package com.sarika.silkhouse.dao;

import java.util.List;

import com.sarika.silkhouse.model.Billing;

public interface Billingdao {
    public void addtobill(Billing bill);
    public void addtobill_details(Billing bill,Long price);
    public List<Billing> billing_details(Long bid);
    public Long billid();
    public Long customerid();
    public Long getprice(int pid);
    public Long gettotalprice(Long bid);
	//public List<Cart> getcart(String uid);
	//public void addquantity(int quantity,int iid,String uid,Cart cart);
	//public void deleteItem(int itemId,String uid);
	//public int gettotal(String uid);

}
