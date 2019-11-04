package com.sarika.silkhouse;


import com.sarika.silkhouse.dao.Categorydao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sarika.silkhouse.dao.Cartdao;
import com.sarika.silkhouse.model.Items;
import com.sarika.silkhouse.model.Cart;
import com.sarika.silkhouse.model.Category;
@Controller
public class CartController {

	@Autowired
	Categorydao categorydao;

	@Autowired
	Cartdao cartdao;

	@RequestMapping(value="buyitem/addtocart/{iid}",method=RequestMethod.GET)
	public String addtocart(Model model,@PathVariable(value="iid") int iid,HttpServletRequest request) 
	{   //System.out.println(" text " );
	if(request.getUserPrincipal()!=null)
       { 
		String uid=request.getUserPrincipal().getName();
		System.out.println(uid);
		Cart cart=new Cart();
		cartdao.addtocart(iid, uid, cart);
		//cartdao.addtocart(iid, uid);
		//System.out.println(" text " );
		return "redirect:/products";
	   }
	   else
	   {return "redirect:/login";}
	}
	@RequestMapping(value="/buyitem/cart")
	public String showcart(Model model,HttpServletRequest request)
	{
		if(request.getUserPrincipal()==null)
        return "redirect:/login";
		String uid=request.getUserPrincipal().getName();

	//	System.out.println(uid);
		List<Cart> list=cartdao.getcart(uid);
		int total=cartdao.gettotal(uid);
		model.addAttribute("list", list);
		//System.out.println(list.get(0).getName());
		model.addAttribute("total",total);
		return "cart";
	}
	@RequestMapping(value="buyitem/update/{iid}")
	public String addquant(Model model,@PathVariable(value="iid") int iid,HttpServletRequest request)
	{
		if(request.getUserPrincipal()==null)
        return "redirect:/login";
		String uid=request.getUserPrincipal().getName();
		Cart cart = new Cart();
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cartdao.addquantity(quantity, iid, uid,cart);
		//cartdao.addquantity(quantity, iid, uid)
		return "redirect:/buyitem/cart";
	}
	@RequestMapping("buyitem/deleteitems/{itemId}")
	public String deleteItem(@PathVariable(value="itemId") int itemId,HttpServletRequest request)
	{ if(request.getUserPrincipal().getName()==null)
        return "redirect:/login";
		String uid=request.getUserPrincipal().getName();
		cartdao.deleteItem(itemId,uid);
		return "redirect:/buyitem/cart";
	}
	

}
