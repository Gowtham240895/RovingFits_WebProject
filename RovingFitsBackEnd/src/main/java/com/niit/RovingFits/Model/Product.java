package com.niit.RovingFits.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int product_Id;
	@Column(nullable = false, unique = true)
	String product_Name;
	@Column(nullable = false, columnDefinition = "text")
	String product_Description;
	@Column(nullable = false)
	int product_Stock;
	@Column(nullable = false)
	float product_Price;
	@ManyToOne
	Category product_Category;

	@Transient
	MultipartFile product_Images;

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getProduct_Description() {
		return product_Description;
	}

	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
	}

	public int getProduct_Stock() {
		return product_Stock;
	}

	public void setProduct_Stock(int product_Stock) {
		this.product_Stock = product_Stock;
	}

	public float getProduct_Price() {
		return product_Price;
	}

	public void setProduct_Price(float product_Price) {
		this.product_Price = product_Price;
	}

	public Category getProduct_Category() {
		return product_Category;
	}

	public void setProduct_Category(Category product_Category) {
		this.product_Category = product_Category;
	}

	public MultipartFile getProduct_Images() {
		return product_Images;
	}

	public void setProduct_Images(MultipartFile product_Images) {
		this.product_Images = product_Images;
	}
	
	

}