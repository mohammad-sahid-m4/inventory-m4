package com.metafour.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metafour.exception.MetafourStarterException;
import com.metafour.model.ProductModel;

@Service
public class ProductService {
	@Autowired
	OrderService orderService;
	List<ProductModel> products = new ArrayList<>();

	// add product
	public void addProduct(ProductModel product) throws MetafourStarterException {
		product.setId(String.valueOf(new Random().nextLong()));
		products.add(product);
	}

	// update product but it is off right now
	public void updateProduct(ProductModel product) throws MetafourStarterException {
		List<ProductModel> rsts = products.stream().filter(r -> r.getId().equals(product.getId()))
				.collect(Collectors.toList());
		if (rsts.isEmpty())
			throw new MetafourStarterException("No product found with ID '" + product.getId() + "' for update!");
		products.remove(rsts.get(0));
		products.add(product);
	}

	// update the product quantity after buying/selling
	public void updateQuantity(String type, String name, int quantity) {
		products.forEach(product -> {
			if (product.getProductName().equalsIgnoreCase(name)) {
				if (type.equalsIgnoreCase("sale")) {
					product.setProductQuantity(product.getProductQuantity() - quantity);
				} else {
					product.setProductQuantity(product.getProductQuantity() + quantity);
				}
			}
		});
	}

	// Search the product in nav search bar
	public List<ProductModel> find(String hint) {
		return hint.equals("?") ? products
				: products.stream()
						.filter(d -> d.getId().toLowerCase().contains(hint.toLowerCase())
								|| d.getProductName().toLowerCase().contains(hint.toLowerCase()))
						.collect(Collectors.toList());
	}

	// get the id of product
	public ProductModel getById(String id) throws MetafourStarterException {
		List<ProductModel> rsts = products.stream().filter(r -> r.getId().equals(id)).collect(Collectors.toList());
		if (rsts.size() != 1)
			return null;
		return rsts.get(0);
	}

	// send all the products
	public List<ProductModel> listAllProducts() {
		return new ArrayList<>(products);
	}

}
