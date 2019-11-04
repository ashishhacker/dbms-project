package com.sarika.silkhouse;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sarika.silkhouse.dao.Cartdao;
import com.sarika.silkhouse.dao.Locationdao;
import com.sarika.silkhouse.model.BLocation;
import com.sarika.silkhouse.model.Cart;
import com.sarika.silkhouse.model.Category;
import com.sarika.silkhouse.model.Event;
import com.sarika.silkhouse.model.GetOrder;
import com.sarika.silkhouse.model.Location;
import com.sarika.silkhouse.model.Order;

@Controller
public class LocationController {
	@Autowired
	Locationdao locationdao;
	@Autowired
	Cartdao cartdao;
	@RequestMapping("location")
	public String location(Model model)
	{
		List<Location> list=locationdao.getallloc();
		model.addAttribute("list",list);
		return "location";
	}
	@RequestMapping("getlocation")
	public String locationt(Model model,HttpServletRequest request)
	{
		Calendar cal=Calendar.getInstance();
//		model.addAttribute("date",LocalDate.now());
		model.addAttribute("date",request.getParameter("bdate"));
		List<Location> list=locationdao.getlocbydate(request.getParameter("bdate"));
		model.addAttribute("list",list);
		return "locmodfy";
	}
	@RequestMapping(value="book/{lid}",method=RequestMethod.GET)
	public String addtocart(Model model,@PathVariable(value="lid") int lid,HttpServletRequest request) 
	{
		String uid=request.getUserPrincipal().getName();
		Cart cart=new Cart();
		locationdao.book(lid, uid, cart,request.getParameter("bdate"));
		return "";
	}
	@RequestMapping(value="bookloc/{lid}/{date}/addevent",method=RequestMethod.GET)
	public String bookloc(Model model,@PathVariable(value="lid") int lid,HttpServletRequest request) 
	{
		List<Event> list=locationdao.addevent();
		model.addAttribute("list",list);
		return "locevent";
	}
	@RequestMapping(value="bookloc/{lid}/{bdate}/select/{event}",method=RequestMethod.GET)
	public String booking(Model model,@PathVariable(value="lid") int lid,@PathVariable(value="bdate") String bdate,@PathVariable(value="event") String event,HttpServletRequest request)
	{
		String uid=request.getUserPrincipal().getName();
		locationdao.booklocation(uid,lid,bdate,event);
		return "redirect:/buyitem/cart";
	}
	@RequestMapping("buyitem/place")
	public String forloc(Model model, HttpServletRequest request)
	{
		String uid=request.getUserPrincipal().getName();
		List<BLocation> list=locationdao.getlocbyuser(uid);
		model.addAttribute("list",list);
		return "locbyuser";
		
	}
	@RequestMapping("buyitem/select/{bid}")
	public String placeorder(Model model,@PathVariable(value="bid") int bid, HttpServletRequest request)
	{
		String uid=request.getUserPrincipal().getName();
		locationdao.placeorder(uid,bid);
		List<Cart> list=cartdao.getcart(uid);
		Iterator<Cart> itr=list.iterator();
		if(!itr.hasNext())
		{
			return "redirect:/cart";
		}
		while(itr.hasNext())
		{
			Cart cart=itr.next();
//			System.out.println(cart.getItemName()+" "+cart.getQuantity());
			locationdao.placeitem(cart.getIid() ,cart.getQuantity(),cart.getTprice(),bid);
			cartdao.deleteItem(cart.getIid(), uid);
		}
		
		return "jingle";
		
	}
	@RequestMapping("order")
	public String getorder(Model model,HttpServletRequest request)
	{
		String uid=request.getUserPrincipal().getName();
		List<Order> list=locationdao.getorder(uid);
		model.addAttribute("list",list);
		return "order";
	}
	@RequestMapping("order/{bid}/{cid}")
	public String getorderbybid(Model model,@PathVariable(value="bid") int bid,@PathVariable(value="cid") int cid)
	{
		List<GetOrder> list=locationdao.getorder2(bid,cid);
		model.addAttribute("list",list);
		return "order2";
	}
	@RequestMapping("admin/order")
	public String getadminorder(Model model,HttpServletRequest request)
	{
		List<Order> list=locationdao.getadminorder();
		model.addAttribute("list",list);
		return "admin/order";
	}
	@RequestMapping("admin/alllocation")
	public String getadminlocation(Model model,HttpServletRequest request)
	{
		List<Location> list=locationdao.getadminlocation();
		model.addAttribute("list",list);
		return "admin/location";
	}
	@RequestMapping(value="admin/addloc",method=RequestMethod.GET)
	public String addcat(Model model)
	{
		Location location=new Location();
		model.addAttribute("location",location);
		return "admin/addloc";
	}
	@RequestMapping(value="admin/addloc",method=RequestMethod.POST)
	public String addItem(@Valid @ModelAttribute("Location") Location location,BindingResult result,Model model) 
	{
		if(result.hasErrors())
		{
			model.addAttribute("location",location);
			return "admin/addcategory";
		}
		else {
			locationdao.addloc(location);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping("admin/order/{bid}/{cid}")
	public String getadminorderbybid(Model model,@PathVariable(value="bid") int bid,@PathVariable(value="cid") int cid)
	{
		List<GetOrder> list=locationdao.getorder2(bid,cid);
		model.addAttribute("list",list);
		return "admin/order2";
	}
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public String upload(Model model,@RequestParam CommonsMultipartFile file)
	{
		byte[] barr=file.getBytes();
		return "";
	}
	@RequestMapping("uploadform")
	public String upload()
	{
		return "upload";
	}
	
}
