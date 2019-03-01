package com.metafour.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.metafour.exception.MetafourStarterException;
import com.metafour.model.OrderModel;
import com.metafour.model.ProductModel;

@Service
public class OrderService {

	List<OrderModel> orders = new ArrayList<>();

	// add order in list
	public void addOrder(OrderModel order) throws MetafourStarterException {
		order.setId(String.valueOf(new Random().nextLong()));
		orders.add(order);
	}

	// update the existing order
	public void updateOrder(OrderModel order) throws MetafourStarterException {
		orders.forEach(ord -> {
			if (ord.getProductName().equalsIgnoreCase(order.getProductName())) {
				if (ord.getOrderType().equalsIgnoreCase("sale")) {
					ord.setProductQuantity(ord.getProductQuantity() + order.getProductQuantity());
					ord.setTotalPrice(ord.getTotalPrice() + order.getTotalPrice());
				}
				if (ord.getOrderType().equalsIgnoreCase("purchase")) {
					ord.setProductQuantity(ord.getProductQuantity() + order.getProductQuantity());
				}
			}
		});
	}

	// find the order form search bar from menu
	public List<OrderModel> find(String hint) {
		return hint.equals("?") ? orders
				: orders.stream()
						.filter(d -> d.getId().toLowerCase().contains(hint.toLowerCase())
								|| d.getProductName().toLowerCase().contains(hint.toLowerCase()))
						.collect(Collectors.toList());
	}

	// find the id of order
	public OrderModel getById(String id) throws MetafourStarterException {
		List<OrderModel> rsts = orders.stream().filter(r -> r.getId().equals(id)).collect(Collectors.toList());
		if (rsts.size() != 1)
			return null;
		return rsts.get(0);
	}

	// send all the order
	public List<OrderModel> listAllOrders() {
		return new ArrayList<>(orders);
	}

	// clear the list of the order
	public void orderClear() {
		orders.clear();
	}

}
