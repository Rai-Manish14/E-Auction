package com.cts.seller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.seller.feign.BuyerFeign;
import com.cts.seller.model.Buyer;

@Service
public class BuyerFeignServiceImpl implements BuyerFeignService {
	@Autowired
	BuyerFeign buyerFeign;

	@Override
	public List<Buyer> getBiddingByProductId(int productId) {
		return buyerFeign.getBidByProductId(productId);
	}
}
