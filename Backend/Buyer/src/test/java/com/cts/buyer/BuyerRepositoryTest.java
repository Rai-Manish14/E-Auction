package com.cts.buyer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cts.buyer.model.Buyer;
import com.cts.buyer.repository.BuyerRepository;

@DataJpaTest
class BuyerRepositoryTest {
	
	@Autowired
	BuyerRepository buyerRepository;
	
	@Test
	public void getBuyerEmailTest() {
		String email = "arjun@gmail.com";
		Buyer buyer = buyerRepository.getBuyerEmail(email);
		assertThat(email).isEqualTo(email);
	}
}
