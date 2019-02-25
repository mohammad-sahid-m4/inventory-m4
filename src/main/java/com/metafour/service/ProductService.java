package com.metafour.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.metafour.exception.MetafourStarterException;
import com.metafour.model.ProductModel;

@Service
public class ProductService {
	
	List<ProductModel> products = new ArrayList<>();
//	public void manualAdd() {
//		ProductModel pm=new ProductModel();
//		pm.setId("3");
//		pm.setName("glass");
//		pm.setProduct_price(40);
////		pm.setDate(new Date(2002,3,1));
//		pm.setQty(4);
//		products.add(pm);
//	}
	
	
	public void addProduct(ProductModel product) throws MetafourStarterException {
		product.setId(String.valueOf(new Random().nextLong()));
		products.add(product);
	}

	public void updatePerson(ProductModel person) throws MetafourStarterException {
		List<ProductModel> rsts = products.stream().filter(r -> r.getId().equals(person.getId())).collect(Collectors.toList());
		if (rsts.isEmpty())
			throw new MetafourStarterException("No Person found with ID '" + person.getId() + "' for update!");
		products.remove(rsts.get(0));
		products.add(person);
	}

	public void deletePerson(ProductModel person) throws MetafourStarterException {
		List<ProductModel> rsts = products.stream().filter(r -> r.getId().equals(person.getId())).collect(Collectors.toList());
		if (rsts.isEmpty())
			throw new MetafourStarterException("No Person found with ID '" + person.getId() + "' for delete!");
		products.remove(rsts.get(0));
	}

	public List<ProductModel> find(String hint) {
		return hint.equals("?")	? products: products.stream().filter(d -> d.getId().toLowerCase().contains(hint.toLowerCase())|| d.getName().toLowerCase().contains(hint.toLowerCase()))
								.collect(Collectors.toList());
	}

	public ProductModel getById(String id) throws MetafourStarterException {
		List<ProductModel> rsts = products.stream().filter(r -> r.getId().equals(id)).collect(Collectors.toList());
		if (rsts.size() != 1)
			return null;
		return rsts.get(0);
	}
	
	public List<ProductModel> listAllProducts() 
	{
	    return new ArrayList<>(products);
	}

	public ProductModel listProductsName() 
	{
	    return products.get(1);
	}
	
	public String ret() {
		 ProductModel retrievedThing = null;
		 Iterator<ProductModel> i = products.iterator();
		 if(i.hasNext()){
		      retrievedThing = i.next();
		 }
		 if(retrievedThing==null) return null;
		 else
		 return retrievedThing.getName();
	}

}
