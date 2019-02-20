package com.metafour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		model.addAttribute("Messege");
		return "index";
	}

	@GetMapping(value = { "order" })
	public String order(Model model) {
		model.addAttribute("Messege");
		return "order";
	}

}
