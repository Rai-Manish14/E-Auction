package com.cts.seller.service;

import java.util.List;

import com.cts.seller.model.Buyer;

public interface BuyerFeignService {
	List<Buyer> getBiddingByProductId(int productId);
}
