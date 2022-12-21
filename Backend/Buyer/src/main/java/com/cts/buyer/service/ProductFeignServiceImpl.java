package com.cts.buyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.buyer.feign.ProductFeign;
import com.cts.buyer.model.Product;

@Service
public class ProductFeignServiceImpl implements ProductFeignService {

	@Autowired
	ProductFeign productfeign;

	@Override
	public Product getProductByProductId(int productId) {
		return productfeign.getProductByProductId(productId);
	}

	@Override
	public Product addProduct(Product product) {
		
		return productfeign.addProduct(product);
	}

}
