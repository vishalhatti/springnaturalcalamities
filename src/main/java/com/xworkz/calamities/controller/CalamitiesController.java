package com.xworkz.calamities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.calamities.dto.CalamitiesDTO;
import com.xworkz.calamities.service.CalamitiesService;

@Component
@RequestMapping("/")
public class CalamitiesController {
	
	@Autowired
	private CalamitiesService calService;

	public CalamitiesController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}
	
	@RequestMapping(value = "/register.odc", method = RequestMethod.POST)
	public String onRegister(CalamitiesDTO dto, Model model) {
		System.out.println("Invoked onRegister() method");
		System.out.println(dto);
		boolean check=this.calService.validateAndSave(dto);
		
		if (check==true) {
			System.out.println("Sending response to success.jsp");
			//model.addAttribute("message", "Info captured by: " + dto.getCapturedBy());
			model.addAttribute("message", "Info captured by: " + dto.getCapturedBy());
			return "success";
		} else {
			return "index";
		}
		
	}

}
