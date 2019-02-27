package com.metafour.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.metafour.exception.MetafourStarterException;
import com.metafour.model.OrderModel;
import com.metafour.service.OrderService;
import com.metafour.service.ProductService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	ProductService productService;

	@RequestMapping
	public String newScreen(final ModelMap model) throws MetafourStarterException {
		return updateScreen(null, model);
	}

	@RequestMapping("/{id}")
	public String updateScreen(@PathVariable String id, final ModelMap model) throws MetafourStarterException {
		model.addAttribute("order", new OrderModel());
		model.addAttribute("order_details", orderService.listAllOrders());
		model.addAttribute("productNames", productService.listAllProducts());
		return "order";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addNewProduct(@Valid OrderModel order, BindingResult binding, final ModelMap model)
			throws MetafourStarterException, BindException {

		Map<String, String> result = new HashMap<>();
		if (binding.hasErrors())
			throw new BindException(binding);

		if (order.getId() == null || orderService.getById(order.getId()) == null)
			orderService.addOrder(order);
		else
			orderService.updateOrder(order);

		result.put("status", "success");
		result.put("redirect", "/" + order.getId());
		return result;
	}
}
