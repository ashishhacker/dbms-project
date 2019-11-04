package com.sarika.silkhouse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.sarika.silkhouse.dao.Billingdao;
import com.sarika.silkhouse.dao.Customerdao;
import com.sarika.silkhouse.dao.Employeedao;
import com.sarika.silkhouse.dao.productdao;
import com.sarika.silkhouse.model.Billing;
import com.sarika.silkhouse.model.Customer;
import com.sarika.silkhouse.model.Employee;
import com.sarika.silkhouse.model.Item;
import com.sarika.silkhouse.model.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class AdminController {
	@Autowired
  public productdao products;
  @Autowired
  public Employeedao employee;
  @Autowired
  public Customerdao customerdao;
  @Autowired
  public Billingdao billdao;
	@RequestMapping("/admin")
	public String admin(Model model) {
     //System.out.println("hello ");
		//String loggedInUserName = principal.getName();
		//model.addAttribute("user", loggedInUserName);
		//model.addAttribute("name", "Spring Security Custom Login Demo");
		//model.addAttribute("description", "Protected page !");
		return "admin";
	}
	@RequestMapping("/403")
	public String permission(Model model) {
  
		return "permission";
	}
	@RequestMapping(value = {"admin/allcat"})
	public String adminproducts(Model model) {
       

        model.addAttribute("products", products.getAllItems());
		return "admin_product";
  }
  @RequestMapping(value = {"admin/allcat/{str}"})
	public String adminShirt(Model model, @PathVariable String str ) {
    
        model.addAttribute("products", products.getfilterItems(str));
        model.addAttribute("var1",str);
		return "admin_product1";
  }
  @RequestMapping(value = {"admin/allcat/{str}/{str2}"})
	public String adminsuit(Model model, @PathVariable String str, @PathVariable String str2) {
  
        model.addAttribute("products", products.getfilterItems(str,str2));
        model.addAttribute("var1",str);
        model.addAttribute("var2",str2);
		return "admin_product2";
  }
  @RequestMapping(value = {"admin/employee"})
	public String adminemployee(Model model) {
		List<Employee> list=employee.getall();
        model.addAttribute("employee", list);
		return "employee";
  }
  @RequestMapping(value = {"admin/employeedelete/{iid}"})
  public String adminemployeedelete(Model model,@PathVariable int iid) {
	  employee.delete(iid);
	  return "redirect:/admin/employee";
}
@RequestMapping(value = {"admin/employee/update/{eid}"},method=RequestMethod.POST)
public String adminemployeeupdate(Model model,@PathVariable int eid,@Valid @ModelAttribute("empl") Employee empl) {
		int quantity = empl.getHoliday();
		
		employee.update(quantity, eid);
		//cartdao.addquantity(quantity, iid, uid)
		return "redirect:/admin/employee";
}

@RequestMapping(value="/admin/employee/addemployee",method=RequestMethod.GET)
	public String registerProcess1(Model model) {
		Profile user = new Profile();
		model.addAttribute("Profile", user);
			return "addemployee";
		
	}
@RequestMapping(value="/admin/employee/addemployee",method=RequestMethod.POST)
	public String registerProcess(@Valid @ModelAttribute("profile") Profile profile,BindingResult result,Model model) {
		
		
			employee.save(profile);
			return "addsuccesful";
		
	}
	@RequestMapping(value="/admin/allcat/additem",method=RequestMethod.GET)
	public String adminaddproduct(Model model) {
		Item user = new Item();
		model.addAttribute("Item", user);
			return "additem";
		
	}

	@RequestMapping(value="/admin/allcat/additem",method=RequestMethod.POST)
	public String adminaddproduct1(@Valid @ModelAttribute("item") Item item,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			return "/admin/allcat/additem";
		}
		else {
			products.save(item);
			return "addsuccesful";
		}
	}
	@RequestMapping(value="/admin/allcustomer")
	public String adminallcustomer(Model model) {
		List<Profile> cust=customerdao.getcustomer();
		model.addAttribute("customer", cust);
		return "allcustomer";
	}

	@RequestMapping(value="/admin/allcustomer/addcustomer",method=RequestMethod.GET)
	public String adminaddcustomer(Model model) {
		Profile profile1 =new Profile();
		model.addAttribute("profile", profile1);
		return "addcustomer";
	}
	
	@RequestMapping(value="/admin/allcustomer/addcustomer",method=RequestMethod.POST)
	public String Addcustomer(@Valid @ModelAttribute("profile") Profile profile,BindingResult result,Model model) {
		
			customerdao.addcustomer(profile);
			return "addsuccesful";
		
	}

	@RequestMapping(value="/admin/billing",method=RequestMethod.GET)
	public String adminbilling(Model model) {
		Billing bill =new Billing();
		model.addAttribute("bill", bill);
		return "billing";
	}
	
	@RequestMapping(value="/admin/billing",method=RequestMethod.POST)
	public String adminbilling1(@Valid @ModelAttribute("bill") Billing bill,BindingResult result,Model model) {
			 billdao.addtobill(bill);
			return "redirect:/admin/billing/details";
	}

	@RequestMapping(value="/admin/billing/details",method=RequestMethod.GET)
	public String billing_details(Model model) {
               Billing bill=new Billing();
			    model.addAttribute("bill", bill);
			   Long bid=billdao.billid();
			   List<Billing> currentbill=billdao.billing_details(bid);
			    model.addAttribute("currentbill", currentbill);
			    return "billing_details";
	}
    @RequestMapping(value="/admin/billing/details",method=RequestMethod.POST)
	public String billing_details(@Valid @ModelAttribute("bill") Billing bill,BindingResult result,Model model) {
		
		Long price =billdao.getprice(bill.getProduct_id());	
		billdao.addtobill_details(bill,price);
			return "redirect:/admin/billing/details";
	}
    @RequestMapping(value="/admin/payment")
	public String payment(Model model) {
		     Long bid=billdao.billid();
			 List<Billing> bill_details= billdao.billing_details(bid);
			 Long cust=billdao.customerid();
			 model.addAttribute("Bill", bill_details);
			 model.addAttribute("customerid",cust );
             Long price1=billdao.gettotalprice(bid);
			 model.addAttribute("totalprice",price1 );
			 return "payment";
	}
	/*@RequestMapping(value="/admin/allbilling",method=RequestMethod.GET)
	public String allbilling(Model model) {
		List<Billing> message= billdao.billing();
		        model.addAttribute("message", message);
			    return "allbilling";
	}
    @RequestMapping(value="/admin/allbilling/{id}")
	public String allbilling_details(Model model,@PathVariable Long id) {
		List<Billing> bill_details= billdao.billing_details(id);
		Long cust=billdao.customerid();
		model.addAttribute("Bill", bill_details);
		model.addAttribute("customerid",cust );
		Long price1=billdao.gettotalprice(id);
		model.addAttribute("totalprice",price1 );
		return "payment";
				
	}
*/



}
