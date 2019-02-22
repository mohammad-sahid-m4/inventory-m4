package com.metafour.controller;

import java.net.BindException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metafour.exception.MetafourStarterException;
import com.metafour.model.OrderModel;
import com.metafour.model.ProductModel;
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
		model.addAttribute("orderDetails", orderService.listAllProducts());
		model.addAttribute("productName", productService.listProductsName());
		return "order";
	}
//		it is very important
//		@RequestMapping("/{id}")
//		public String updateScreen(@PathVariable String id, final ModelMap model) throws MetafourStarterException {
//			model.addAttribute("product", id == null ? new ProductModel() : personService.getById(id));
//			model.addAttribute("product_details",personService.listAllProducts());
//			return "product";
//		}

	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addNewOrder(@Valid OrderModel order, BindingResult binding, final ModelMap model)
			throws MetafourStarterException, BindException {
		Map<String, String> result = new HashMap<>();
		if (binding.hasErrors())
//			throw new BindException(binding);

		if (order.getId() == null || orderService.getById(order.getId()) == null)
			orderService.addProduct(order);
		else
			orderService.updatePerson(order);

		result.put("status", "success");
		result.put("redirect", "/" + order.getId());
		return result;
	}
}
