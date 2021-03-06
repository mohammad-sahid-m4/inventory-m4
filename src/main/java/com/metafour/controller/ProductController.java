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
import com.metafour.model.ProductModel;
import com.metafour.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping
	public String newScreen(final ModelMap model) throws MetafourStarterException {
		return updateScreen(null, model);
	}

	@RequestMapping("/{id}")
	public String updateScreen(@PathVariable String id, final ModelMap model) throws MetafourStarterException {
		model.addAttribute("product", new ProductModel());
		model.addAttribute("product_details", productService.listAllProducts());
		return "product";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addNewProduct(@Valid ProductModel product, BindingResult binding, final ModelMap model)
			throws MetafourStarterException, BindException {
		Map<String, String> result = new HashMap<>();
		if (binding.hasErrors())
			throw new BindException(binding);
		if (product.getId() == null || productService.getById(product.getId()) == null)
			productService.addProduct(product);
		else
			productService.updateProduct(product);
		result.put("status", "success");
		result.put("redirect", "/" + product.getId());
		return result;
	}
}
