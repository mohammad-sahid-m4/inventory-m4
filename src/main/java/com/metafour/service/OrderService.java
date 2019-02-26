package com.metafour.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.metafour.exception.MetafourStarterException;
import com.metafour.model.OrderModel;

@Service
public class OrderService {

	List<OrderModel> orders = new ArrayList<>();
//	public void manualAdd() {
//		ProductModel pm=new ProductModel();
//		pm.setId("3");
//		pm.setName("glass");
//		pm.setProduct_price(40);
////		pm.setDate(new Date(2002,3,1));
//		pm.setQty(4);
//		orders.add(pm);
//	}

	public void addOrder(OrderModel order) throws MetafourStarterException {
		order.setId(String.valueOf(new Random().nextLong()));
		orders.add(order);
	}

	public void updateOrder(OrderModel person) throws MetafourStarterException {
		List<OrderModel> rsts = orders.stream().filter(r -> r.getId().equals(person.getId()))
				.collect(Collectors.toList());
		if (rsts.isEmpty())
			throw new MetafourStarterException("No Person found with ID '" + person.getId() + "' for update!");
		orders.remove(rsts.get(0));
		orders.add(person);
	}

	public void deletePerson(OrderModel person) throws MetafourStarterException {
		List<OrderModel> rsts = orders.stream().filter(r -> r.getId().equals(person.getId())).collect(Collectors.toList());
		if (rsts.isEmpty())
			throw new MetafourStarterException("No Person found with ID '" + person.getId() + "' for delete!");
		orders.remove(rsts.get(0));
	}

	public List<OrderModel> find(String hint) {
		return hint.equals("?") ? orders: orders.stream().filter(d -> d.getId().toLowerCase().contains(hint.toLowerCase())|| d.getProductName().toLowerCase().contains(hint.toLowerCase())).collect(Collectors.toList());
	}

	public OrderModel getById(String id) throws MetafourStarterException {
		List<OrderModel> rsts = orders.stream().filter(r -> r.getId().equals(id)).collect(Collectors.toList());
		if (rsts.size() != 1)
			return null;
		return rsts.get(0);
	}

	public List<OrderModel> listAllOrders() {
		return new ArrayList<>(orders);
	}

}
