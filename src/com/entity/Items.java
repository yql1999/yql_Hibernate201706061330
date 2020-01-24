package com.entity;

import java.io.Serializable;

public class Items implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer items_id;
	private String items_name;
	private double items_price;
	private Integer items_amount;
	private double items_total;
	private Category category;

	public Items() {
		super();
	}

	public Items(Integer items_id, String items_name, double items_price, Integer items_amount, double items_total,
			Category category) {
		super();
		this.items_id = items_id;
		this.items_name = items_name;
		this.items_price = items_price;
		this.items_amount = items_amount;
		this.items_total = items_total;
		this.category = category;
	}

	public Integer getItems_id() {
		return items_id;
	}

	public void setItems_id(Integer items_id) {
		this.items_id = items_id;
	}

	public String getItems_name() {
		return items_name;
	}

	public void setItems_name(String items_name) {
		this.items_name = items_name;
	}

	public double getItems_price() {
		return items_price;
	}

	public void setItems_price(double items_price) {
		this.items_price = items_price;
	}

	public Integer getItems_amount() {
		return items_amount;
	}

	public void setItems_amount(Integer items_amount) {
		this.items_amount = items_amount;
	}

	public double getItems_total() {
		return items_total;
	}

	public void setItems_total(double items_total) {
		this.items_total = items_total;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
