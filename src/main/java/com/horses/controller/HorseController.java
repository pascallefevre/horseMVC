package com.horses.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.horses.dao.IHorseDao;
import com.horses.domain.EColor;
import com.horses.domain.Horse;

@Controller
@RequestMapping("/horse")
public class HorseController 
{
	@Autowired
	IHorseDao hdao;
	
	@RequestMapping(value= "/add", method= RequestMethod.GET)
	public String addget(Model model) {
		Horse h = new Horse();
		model.addAttribute("color",EColor.values() );
		model.addAttribute("newhorse", h);
		return "fhorse/add";
	}
	
	@RequestMapping(value= "/add", method= RequestMethod.POST)
	public String addpost(@ModelAttribute("newhorse") Horse horse ) {
		hdao.save(horse);
		return "redirect: /horseMVC/horse/show";
	}
	
	@RequestMapping(value= "/edit/{id}", method= RequestMethod.GET)
	public String editget(Model model, @PathVariable(value="id") int id) {
		Horse h = hdao.findById(id).get();
		model.addAttribute("color",EColor.values() );
		model.addAttribute("newhorse", h);
		model.addAttribute("action","edit");
		return "fhorse/add";
	}
	
	@RequestMapping(value= "/delete/{id}", method= RequestMethod.GET)
	public String rmget(Model model,@PathVariable(value="id") int id) {
		Horse h = hdao.findById(id).get();
		if(h!=null) 
		{
			hdao.deleteById(id);
			return "fhorse/show";
		}
		else 
			return "fhorse/show";
	}
	
	@RequestMapping(value= "/show", method = RequestMethod.GET)
	public String show(Model model) {
		List<Horse> lhorse = (List<Horse>)hdao.findAll();
		model.addAttribute("lhorse", lhorse );
		return "fhorse/show";
	}
	
	@InitBinder       
	public void initBinder(WebDataBinder binder) 
	{           
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		sdf.setLenient(true); 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));  
	}
}
