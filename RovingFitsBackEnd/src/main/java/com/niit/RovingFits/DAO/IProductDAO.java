package com.niit.RovingFits.DAO;

import java.util.ArrayList;

import com.niit.RovingFits.Model.Category;
import com.niit.RovingFits.Model.Product;

public interface IProductDAO {

	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

	public boolean deleteProduct(Product product);

	public ArrayList<Product> allProduct();

	public Product oneProduct(int product_id);

	public ArrayList<Product> allProductByCategory(Category category);

}
