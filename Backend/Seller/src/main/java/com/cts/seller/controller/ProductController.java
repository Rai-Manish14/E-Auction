package com.cts.seller.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.seller.model.Buyer;
import com.cts.seller.model.Product;
import com.cts.seller.service.BuyerFeignService;
import com.cts.seller.service.ProductService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	BuyerFeignService buyerFeignService;

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {

		return ResponseEntity.ok(productService.addProduct(product));
	}

	@ApiIgnore
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@ApiIgnore
	@GetMapping("/getProductByProductName/{productName}")
	public ResponseEntity<?> getProductByProductName(@PathVariable String productName) {
		if(productService.getProductByProductName(productName)!=null) {
			return ResponseEntity.ok(productService.getProductByProductName(productName));
		}
		else
		{
			return new ResponseEntity<String>("Please check the input and try agian!",HttpStatus.NOT_FOUND);
		}
	}

	@ApiIgnore
	@GetMapping("/getProductByProductId/{productId}")
	public ResponseEntity<Product> getProductByProductId(@PathVariable int productId) {
		return ResponseEntity.ok(productService.getProductByProductId(productId));
	}
	
	@GetMapping("/show-bids/{productId}")
	public ResponseEntity<List<Buyer>> getBiddingByProductId(@PathVariable int productId) {
		return ResponseEntity.ok(buyerFeignService.getBiddingByProductId(productId));
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProductByProductId(@PathVariable int productId) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String currDate = dtf.format(now);
		System.out.println(currDate);
//		System.out.println(productService.deleteProduct(productId));
		String date = (productService.getProductByProductId(productId)) == null ? ""
				: productService.getProductByProductId(productId).getBidEndDate();
		if (!date.isEmpty() && currDate.compareTo(date) <= 0
				&& productService.getProductByProductId(productId).getBidAmount() == 0) {
			productService.deleteProduct(productId);
			return ResponseEntity.ok("Product Deleted with product Id #" + productId);
		} else {
			return ResponseEntity.ok("Product Id #" + productId + " cannot be deleted");
		}
	}

}
