package com.cts.seller.service;

import java.util.List;

import com.cts.seller.model.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	
	Product getProductByProductId(int productId);
	
	List<Product> getAllProducts();
	
	int deleteProduct(int productId);
	
	Product getProductByProductName(String name);
}
