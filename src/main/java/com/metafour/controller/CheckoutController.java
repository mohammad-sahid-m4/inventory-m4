package com.metafour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.metafour.exception.MetafourStarterException;
import com.metafour.service.OrderService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	@Autowired
	OrderService orderService;
	@RequestMapping
	public String updateScreen(final ModelMap model) throws MetafourStarterException {
		model.addAttribute("order_details", orderService.listAllOrders());
		return "checkout";
	}

}
