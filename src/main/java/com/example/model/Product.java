package com.example.model;

import java.sql.Date;
import java.time.LocalDate;

public class Product {
	private Long id;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date date) {
		this.expiry_date = date;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	private String name;
    private Double price;
    private String description;
    private String category;
    private Date expiry_date;
    private String image_url;

}
