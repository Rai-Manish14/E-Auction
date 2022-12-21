package com.cts.buyer.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.buyer.model.Buyer;
import com.cts.buyer.model.Product;
import com.cts.buyer.service.BuyerService;
import com.cts.buyer.service.ProductFeignService;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class BuyerController {

	@Autowired
	BuyerService buyerService;

	@Autowired
	ProductFeignService productFeignService;

	@ApiIgnore
	@GetMapping("/show-bids/{ProductId}")
	public ResponseEntity<List<Buyer>> getBuyerByBuyerId(@PathVariable int ProductId) {
		log.info("Inside getBuyerByBuyerId()");
		return ResponseEntity.ok(buyerService.getBuyerByProductId(ProductId));
	}

	@PostMapping("/place-bid")
	public ResponseEntity<?> placeBid(@RequestBody Buyer buyer) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		System.out.println(date);

		List<Buyer> allbuyers = buyerService.getBuyerByProductId(buyer.getProductId());
		int temp = 0;
		for(int i=0;i<allbuyers.size();i++) {

			System.out.println(allbuyers.get(i).getEmail());
			System.out.println(buyer.getEmail());
			System.out.println(allbuyers.get(i).getEmail().equals(buyer.getEmail()));
			if(allbuyers.get(i).getEmail().equals(buyer.getEmail())) {
				temp=1;
				System.out.println(allbuyers.get(i).getEmail());
				break;
			}
		}

		int productId = buyer.getProductId();
		if (productFeignService.getProductByProductId(buyer.getProductId()) != null
				&& date.compareTo(productFeignService.getProductByProductId(productId).getBidEndDate()) <= 0
				&& buyer.getBidAmount() >= productFeignService.getProductByProductId(productId).getStartingPrice()
				&& temp==0) {
			Product product = productFeignService.getProductByProductId(buyer.getProductId());
			product.setBidAmount(buyer.getBidAmount());
			productFeignService.addProduct(product);
			return ResponseEntity.ok(buyerService.addBuyer(buyer));
		} else {
			return new ResponseEntity<>("Cannot place bid", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/update-bid/{productId}/{email}/{bidAmount}")
	public ResponseEntity<String> updateBid(@PathVariable int productId, @PathVariable String email,
			@PathVariable long bidAmount) {

		int currentPId = (buyerService.getBuyerByEmail(email)) == null ? 0
				: buyerService.getBuyerByEmail(email).getProductId();
		if (currentPId == productId) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			String date = dtf.format(now);
			System.out.println(buyerService.getBuyerByEmail(email).getBidAmount() + " bid amount " + bidAmount);
			System.out.println(productFeignService.getProductByProductId(productId).getBidEndDate() + " " + date);
			if ((buyerService.getBuyerByEmail(email).getBidAmount()) < bidAmount
					&& date.compareTo(productFeignService.getProductByProductId(productId).getBidEndDate()) <= 0) {
				buyerService.getBuyerByEmail(email).setBidAmount(bidAmount);
				buyerService.addBuyer(buyerService.getBuyerByEmail(email));
				Product product = productFeignService.getProductByProductId(productId);
				product.setBidAmount(bidAmount);
				productFeignService.addProduct(product);
				return ResponseEntity.ok("Bidding amount changed successfully");
			} else {
				return new ResponseEntity<String>("Cannot change bid. Please try again", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>("Please check the inputs and try again", HttpStatus.BAD_REQUEST);
		}

	}

}
