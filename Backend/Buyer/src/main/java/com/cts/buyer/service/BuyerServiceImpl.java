package com.cts.buyer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.buyer.model.Buyer;
import com.cts.buyer.repository.BuyerRepository;

@Service
public class BuyerServiceImpl implements BuyerService {
	
	@Autowired
	BuyerRepository buyerRepository;

	@Override
	public Buyer addBuyer(Buyer Buyer) {
		return buyerRepository.save(Buyer);
	}

	@Override
	public Buyer getBuyer(int buyerId) {
		return buyerRepository.findById(buyerId).orElse(null);
	}

	@Override
	public Buyer updateBid(Buyer buyer) {
		return buyerRepository.save(buyer);
	}

	@Override
	public Buyer getBuyerByEmail(String Email) {
		return buyerRepository.getBuyerEmail(Email);
	}

	@Override
	public List<Buyer> getBuyerByProductId(int ProductId) {
		
		return buyerRepository.getBuyerByProductId(ProductId);
	}


}
