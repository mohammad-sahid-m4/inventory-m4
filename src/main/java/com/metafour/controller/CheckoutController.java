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

	// buy/sell complete
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("success", "Thank you for shopping");
		buyList();
		if (orderService.listAllOrders().isEmpty()) {
			model.addAttribute("success", "You do not buy or sell anything");
		}
		orderService.orderClear();
		return "index";
	}
	
	//	update the product quantity after buying/selling
	public void buyList() {
		orderService.listAllOrders().forEach(product -> productService.updateQuantity(product.getOrderType(),
				product.getProductName(), product.getProductQuantity()));
	}
}
