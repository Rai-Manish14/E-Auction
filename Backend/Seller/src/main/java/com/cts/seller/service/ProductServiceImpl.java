package com.cts.seller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.seller.model.Product;
import com.cts.seller.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);

	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAllProduct();
	}

	@Override
	public int deleteProduct(int productId) {
		try {
			productRepository.deleteById(productId);
			return productId;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public Product getProductByProductId(int productId) {

		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public Product getProductByProductName(String name) {
		try {
			return productRepository.findProductbyProductName(name);
		} catch (Exception e) {
			return null;
		}
	}

}
