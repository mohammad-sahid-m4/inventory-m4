package com.metafour.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.metafour.validation.uniqueName;
import com.metafour.validation.validPrice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
public class ProductModel {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

	private String id;
	@NotEmpty(message = "Product name is required")
	@uniqueName
	private String productName;
	@validPrice
	private int productPrice;
	@Min(value = 1, message = "Quantity must be equal or more than 1")
	private int productQuantity;
	@NotNull
	private String productDate = dateFormat.format(new Date());

	public ProductModel() {
	}

	public ProductModel(@NotEmpty(message = "Product name is required") @uniqueName String productName,
			@validPrice int productPrice,
			@Min(value = 1, message = "Quantity must be equal or more than 1") int productQuantity,
			@NotNull String productDate) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productDate = productDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

}
