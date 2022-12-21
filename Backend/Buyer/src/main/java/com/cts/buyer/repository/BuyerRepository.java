package com.cts.buyer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.buyer.model.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
	
	@Query("Select b from Buyer b where Email = ?1")
	Buyer getBuyerEmail(String email);
	
	@Query("Select b from Buyer b where Product_Id = ?1 order by Bid_Amount desc")
	List<Buyer> getBuyerByProductId(int productId);

}
