package com.niit.ecommercebackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")
@Component
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
	@Transient
	private MultipartFile image;
	@NotNull(message = "productname cannot be blank")
	private String product_name;
	@Min(1)
	private String product_quantity;
	@Min(1)
	private String product_weight;
	@Min(1)
	private String product_price;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getProduct_weight() {
		return product_weight;
	}
	public void setProduct_weight(String product_weight) {
		this.product_weight = product_weight;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	
	
}
