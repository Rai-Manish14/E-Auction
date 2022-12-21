package com.cts.buyer.service;

import com.cts.buyer.model.Product;

public interface ProductFeignService {

	Product getProductByProductId(int productId);
	
	Product addProduct(Product product);
}
