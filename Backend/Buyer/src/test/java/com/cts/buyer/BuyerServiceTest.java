package com.cts.buyer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.buyer.model.Buyer;
import com.cts.buyer.repository.BuyerRepository;
import com.cts.buyer.service.BuyerServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class BuyerServiceTest {

	@Mock
	private BuyerRepository buyerRepository;

	@InjectMocks
	private BuyerServiceImpl buyerService;

	private Buyer buyer1;
	private Buyer buyer2;

	@BeforeEach
	public void setup() {
		buyer1 = Buyer.builder().buyerId(1).firstName("Manish").lastName("Rai").address("11/2 Kolkata").city("Bhatpara")
				.state("West Bengal").pin(743126).phone(96787654).email("arjun@gmail.com").productId(1).bidAmount(500)
				.build();

		buyer2 = new Buyer();
		buyer2.setBuyerId(buyer1.getBuyerId());
		buyer2.setFirstName(buyer1.getFirstName());
		buyer2.setLastName(buyer1.getLastName());
		buyer2.setAddress(buyer1.getAddress());
		buyer2.setCity(buyer1.getCity());
		buyer2.setState(buyer1.getState());
		buyer2.setPin(buyer1.getPin());
		buyer2.setPhone(buyer1.getPhone());
		buyer2.setEmail(buyer1.getEmail());
		buyer2.setProductId(buyer1.getProductId());
		buyer2.setBidAmount(800);

//		buyer2 = Buyer.builder().buyerId(1).firstName("Manish").lastName("Rai").address("11/2 Kolkata").city("Bhatpara")
//				.state("West Bengal").pin(743126).phone(96787654).email("arjun@gmail.com").productId(1).bidAmount(800)
//				.build();
	}

	// Junit test for addBuyer method
	@Test
	public void addBuyer() {

		System.out.println("Add Buyer");
		// given - precondition or setup
		given(buyerRepository.save(buyer1)).willReturn(buyer1);

		// When - action or behavior that we are going to test
		Buyer savedBuyer = buyerService.addBuyer(buyer1);
		System.out.println(savedBuyer);

		// then - verify the output
		assertThat(savedBuyer).isNotNull();

	}

	@Test
	public void getBuyer() {

		System.out.println("Get Buyer");
		// given - precondition or setup
		given(buyerRepository.save(buyer1)).willReturn(buyer1);
		given(buyerRepository.findById(buyer1.getBuyerId())).willReturn(Optional.of(buyer1));

		// When - action or behavior that we are going to test
		Buyer savedBuyer = buyerService.addBuyer(buyer1);
		Buyer getBuyer = buyerService.getBuyer(savedBuyer.getBuyerId());
		System.out.println(savedBuyer);
		System.out.println(getBuyer);

		// then - verify the output
		assertThat(getBuyer).isNotNull();
	}

	@Test
	public void updateBid() {

		System.out.println("Update Bid");
		// given - precondition or setup
		given(buyerRepository.save(buyer1)).willReturn(buyer1);
		given(buyerRepository.save(buyer2)).willReturn(buyer2);

		// When - action or behavior that we are going to test
		Buyer savedBuyer = buyerService.addBuyer(buyer1);
		Buyer updatedBuyer = buyerService.updateBid(buyer2);
		System.out.println(savedBuyer);
		System.out.println(updatedBuyer);

		// then - verify the output
		assertThat(updatedBuyer.getBidAmount()).isNotEqualTo(savedBuyer.getBidAmount());
	}

	@Test
	public void getBuyerByEmail() {

		System.out.println("Get Buyer By Email");
		// given - precondition or setup
		given(buyerRepository.save(buyer1)).willReturn(buyer1);
		given(buyerRepository.getBuyerEmail(buyer1.getEmail())).willReturn(buyer1);

		// When - action or behavior that we are going to test
		Buyer savedBuyer = buyerService.addBuyer(buyer1);
		Buyer buyerByEmail = buyerService.getBuyerByEmail(savedBuyer.getEmail());
		System.out.println(savedBuyer);
		System.out.println(buyerByEmail);

		// then - verify the output
		assertThat(buyerByEmail).isEqualTo(savedBuyer);
	}

	@Test
	public void getBuyerByProductId() {
		System.out.println("Get Buyer By ProductId");
		// given - precondition or setup
		given(buyerRepository.save(buyer1)).willReturn(buyer1);
		given(buyerRepository.getBuyerByProductId(buyer1.getProductId())).willReturn(List.of(buyer1));

		// When - action or behavior that we are going to test
		Buyer savedBuyer = buyerService.addBuyer(buyer1);
		List<Buyer> buyerByProductId = buyerService.getBuyerByProductId(savedBuyer.getProductId());
		System.out.println(savedBuyer);

		// then - verify the output
		assertThat(buyerByProductId).isNotNull();
	}

}
