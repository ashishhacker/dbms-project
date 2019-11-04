package com.sarika.silkhouse;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sarika.silkhouse.dao.Userdao;
import com.sarika.silkhouse.dao.productdao;
import com.sarika.silkhouse.model.User;
@Controller
public class productscontroller{
  @Autowired
  public productdao products;
    @RequestMapping(value = {"/products"})
	public String products(Model model) {
       

        model.addAttribute("products", products.getAllItems());
		return "products";
  }
  @RequestMapping(value = {"/products/{str}"})
	public String Shirt(Model model, @PathVariable String str ) {
    
        model.addAttribute("products", products.getfilterItems(str));
        model.addAttribute("var1",str);
		return "products1";
  }
  @RequestMapping(value = {"/products/{str}/{str2}"})
	public String suit(Model model, @PathVariable String str, @PathVariable String str2) {
  
        model.addAttribute("products", products.getfilterItems(str,str2));
        model.addAttribute("var1",str);
        model.addAttribute("var2",str2);
		return "products2";
  }
  

}
