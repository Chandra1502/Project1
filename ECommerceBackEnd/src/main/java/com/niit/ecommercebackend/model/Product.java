package com.niit.ecommercebackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int product_quantity;
	@Min(1)
	private int product_weight;
	@Min(1)
	private int product_price;
	
	@Column(name="category_id")
	private int category_id;
	@Column(name="supplier_id")
	private int supplier_id;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="category_id",insertable=false,updatable=false)
	private Category category;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="supplier_id",insertable=false,updatable=false)
	private Supplier supplier;
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public int getProduct_weight() {
		return product_weight;
	}
	public void setProduct_weight(int product_weight) {
		this.product_weight = product_weight;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
	
}
