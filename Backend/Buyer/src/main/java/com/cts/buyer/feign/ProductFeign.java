package com.cts.buyer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.buyer.model.Product;

@FeignClient(name = "ProductFeignClient", url= "${Product.baseUrl}")
public interface ProductFeign {
	
	@GetMapping("/getProductByProductId/{productId}")
	public Product getProductByProductId(@PathVariable int productId);
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product);

}
