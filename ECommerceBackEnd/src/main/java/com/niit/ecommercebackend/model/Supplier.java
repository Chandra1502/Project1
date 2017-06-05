package com.niit.ecommercebackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Table(name="supplier")
@Component
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplier_id;

	@NotBlank(message = "supplier name cannot be blank")
	private String supplier_name;
	@NotBlank(message = "supplier location cannot be blank")
	private String supplier_location;
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_location() {
		return supplier_location;
	}
	public void setSupplier_location(String supplier_location) {
		this.supplier_location = supplier_location;
	}
	
}
