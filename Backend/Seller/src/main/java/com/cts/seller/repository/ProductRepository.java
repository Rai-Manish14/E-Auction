package com.cts.seller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.seller.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "Select p from Product p order by Bid_Amount desc")
	public List<Product> findAllProduct();
	
	@Query(value = "Select p from Product p where Product_Name=?1")
	public Product findProductbyProductName(String name);
	
	

}
