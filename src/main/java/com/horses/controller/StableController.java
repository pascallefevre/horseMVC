package com.horses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.horses.dao.IStable;
import com.horses.domain.EColor;
import com.horses.domain.Horse;
import com.horses.domain.Stable;

@Controller
@RequestMapping("/stable")
public class StableController {

	@Autowired
	IStable sdao;
	
	
	@RequestMapping(value= "/show", method = RequestMethod.GET)
	public String show(Model model) {
		List<Stable> lstable = (List<Stable>)sdao.findAll();
		model.addAttribute("lstable", lstable );
		return "fstable/show";
	}
	
	@RequestMapping(value= "/add", method= RequestMethod.GET)
	public String addget(Model model) {
		Stable s = new Stable();
		model.addAttribute("color",EColor.values() );
		model.addAttribute("newstable", s);
		return "fstable/add";
	}
	
	@RequestMapping(value= "/add", method= RequestMethod.POST)
	public String addpost(@ModelAttribute("newstable") Stable stable ) {
		sdao.save(stable);
		return "redirect: /horseMVC/stable/show";
	}
	
	@RequestMapping(value= "/edit/{id}", method= RequestMethod.GET)
	public String editget(Model model, @PathVariable(value="id") int id) {
		Stable s = sdao.findById(id).get();
		model.addAttribute("color",EColor.values() );
		model.addAttribute("newstable", s);
		model.addAttribute("action","edit");
		return "fstable/add";
	}
	
	@RequestMapping(value= "/delete/{id}", method= RequestMethod.GET)
	public String rmget(Model model,@PathVariable(value="id") int id) {
		Stable s = sdao.findById(id).get();
		if(s!=null) 
		{
			sdao.deleteById(id);
			return "fstable/show";
		}
		else 
			return "fstable/show";
	}
}
