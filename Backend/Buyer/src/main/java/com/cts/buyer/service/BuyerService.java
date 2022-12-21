package com.cts.buyer.service;

import java.util.List;

import com.cts.buyer.model.Buyer;

public interface BuyerService {

	Buyer addBuyer(Buyer buyer);
	
	Buyer updateBid(Buyer buyer);
	
	Buyer getBuyer(int buyerId);
	
	Buyer getBuyerByEmail(String Email);
	
	List<Buyer> getBuyerByProductId(int ProductId);
	
}
