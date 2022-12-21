package com.cts.seller.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.seller.model.Buyer;


@FeignClient(name = "BuyerFeignClient", url = "${Buyer.baseUrl}")
public interface BuyerFeign {
	@GetMapping("/show-bids/{productId}")
	public List<Buyer> getBidByProductId(@PathVariable int productId);
}
