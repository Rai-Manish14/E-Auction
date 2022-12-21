package com.cts.seller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.seller.model.Buyer;
import com.cts.seller.service.BuyerFeignServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BuyerFeignServiceTest {
	
	@InjectMocks
	BuyerFeignServiceImpl buyerFeignServiceImpl;
	
	private Buyer buyer;
	
	@BeforeEach
	public void setup() {
		buyer = Buyer.builder()
				.buyerId(1)
				.firstName("Arjun")
				.lastName("Rai")
				.address("11/2 Kolkata")
				.city("Bhatpara")
				.state("West Bengal")
				.pin(743126)
				.phone(987672289)
				.email("arjun@gmail.com")
				.productId(1)
				.bidAmount(500)
				.build();
	}
	@Test
	public void getBiddingByProductId() {
		
		// When - action or behavior that we are going to test
		
		List<Buyer> buyerList = buyerFeignServiceImpl.getBiddingByProductId(1);

		System.out.println(buyerList);
		// then - verify the output
		assertThat(buyerList).isEmpty();
		assertThat(buyerList.size()).isEqualTo(0);
	}

}
