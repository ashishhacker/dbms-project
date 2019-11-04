package com.sarika.silkhouse;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sarika.silkhouse.dao.Categorydao;
import com.sarika.silkhouse.model.Category;
import com.sarika.silkhouse.model.Item;
import com.sarika.silkhouse.model.Location;
import com.sarika.silkhouse.model.User;

@Controller
public class CategoryController {
	@Autowired
	Categorydao categorydao;
	@RequestMapping("allcat")
	public String category(Model model)
	{
		List<Category> list=categorydao.getallcat();
		model.addAttribute("list",list);
		return "category";
	}
	@RequestMapping("admin/allusers")
	public String allusers(Model model)
	{
		List<User> list=categorydao.getallusers();
		model.addAttribute("list",list);
		return "alluser";
	}
	
	@RequestMapping(value="admin/addcat",method=RequestMethod.GET)
	public String addcat(Model model)
	{
		Category category=new Category();
		model.addAttribute("category",category);
		return "admin/addcategory";
	}
	@RequestMapping(value="admin/addcat",method=RequestMethod.POST)
	public String addItem(@Valid @ModelAttribute("Category") Category category,BindingResult result,Model model) 
	{
		if(result.hasErrors())
		{
			model.addAttribute("category",category);
			return "admin/addcategory";
		}
		else {
			categorydao.addCat(category);
			return "redirect:/admin";
		}
	}

}
