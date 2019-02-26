package com.metafour.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	private SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy");

	private String id;
	@NotEmpty
	private String productName;
	@validPrice
	private int productPrice;
	@Min(value = 1, message = "Quantity must be equal or more than 1")
	private int productQuantity;
	@NotNull
	private String productDate = dateFormat.format(new Date());

}
