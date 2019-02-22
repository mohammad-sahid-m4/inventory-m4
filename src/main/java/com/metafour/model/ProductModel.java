package com.metafour.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	private String name;
	@Min(value = 1, message = "The value must be greater than 0")
	private int product_price;
	@Min(value = 1, message = "The value must be greater than 0")
	private int qty;
	@NotNull
	private String date = dateFormat.format(new Date());

}
