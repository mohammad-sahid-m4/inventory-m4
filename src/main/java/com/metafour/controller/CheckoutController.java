package com.metafour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.metafour.exception.MetafourStarterException;
import com.metafour.service.OrderService;
import com.metafour.service.ProductService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	@Autowired
	OrderService orderService;
	@Autowired
	ProductService productService;

	@RequestMapping
	public String updateScreen(final ModelMap model) throws MetafourStarterException {
		model.addAttribute("order_details", orderService.listAllOrders());
		return "checkout";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("success", "Buying/selling completed successfully");
		buyList();
		orderService.orderClear();
		return "index";
	}

	public void buyList() {
		orderService.listAllOrders().forEach(product -> productService.updateQuantity(product.getOrderType(),
				product.getProductName(), product.getProductQuantity()));
	}
}
