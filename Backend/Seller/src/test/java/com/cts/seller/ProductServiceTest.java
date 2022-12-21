package com.cts.seller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.seller.model.Product;
import com.cts.seller.repository.ProductRepository;
import com.cts.seller.service.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	private Product product1;
	private Product product2;

	@BeforeEach
	public void setup() {
		product1 = Product.builder().productId(2).productName("Pizza").shortDescription("good")
				.detailedDescription("Very good").category("Fast Food").startingPrice(200).bidEndDate("2022/11/30")
				.firstName("Manish").lastName("Rai").address("11/2 Kolkata").city("Bhatpara").state("West Bengal")
				.pin(743126).phone(96787654).email("arjun@gmail.com").build();

		product2 = new Product();
		product2.setFirstName(product1.getFirstName());
		product2.setAddress(product1.getAddress());
		product2.setBidAmount(product1.getBidAmount());
		product2.setBidEndDate(product1.getBidEndDate());
		product2.setCategory(product1.getCategory());
		product2.setCity(product1.getCity());
		product2.setDetailedDescription(product1.getDetailedDescription());
		product2.setEmail(product1.getEmail());
		product2.setLastName(product1.getLastName());
		product2.setPhone(product1.getPhone());
		product2.setPin(product1.getPin());
		product2.setProductId(product1.getProductId());
		product2.setProductName(product1.getProductName());
		product2.setShortDescription(product1.getShortDescription());
		product2.setStartingPrice(product1.getStartingPrice());
		product2.setState(product1.getState());
	}

	@Test
	public void addProduct() {

		System.out.println("Add Buyer");
		// given - precondition or setup
		given(productRepository.save(product2)).willReturn(product2);

		// When - action or behavior that we are going to test
		Product savedProduct = productServiceImpl.addProduct(product2);
		System.out.println(savedProduct);

		// then - verify the output
		assertThat(savedProduct).isNotNull();
	}

	@Test
	public void getProductByProductId() {
		System.out.println("Get Product By ProductId");
		// given - precondition or setup
		given(productRepository.save(product1)).willReturn(product1);
		given(productRepository.findById(product1.getProductId())).willReturn(Optional.of(product1));

		// When - action or behavior that we are going to test
		Product savedProduct = productServiceImpl.addProduct(product1);
		Product getProduct = productServiceImpl.getProductByProductId(savedProduct.getProductId());
		System.out.println(savedProduct);
		System.out.println(getProduct);

		// then - verify the output
		assertThat(getProduct).isNotNull();
	}

	@Test
	public void getProductByProductName() {
		System.out.println("Get Product By ProductName	");
		// given - precondition or setup
		given(productRepository.save(product2)).willReturn(product2);

		// When - action or behavior that we are going to test
		Product savedProduct = productServiceImpl.addProduct(product2);
		Product getProduct = productServiceImpl.getProductByProductName(savedProduct.getProductName());
		System.out.println(savedProduct.getProductName());
		System.out.println(getProduct);

		// then - verify the output
		assertThat(getProduct).isNull();
	}

	@Test
	public void getAllProducts() {

		System.out.println("Get All Products");

		// When - action or behavior that we are going to test
		List<Product> productList = productServiceImpl.getAllProducts();

		System.out.println(productList);
		// then - verify the output
		assertThat(productList).isEmpty();
		assertThat(productList.size()).isEqualTo(0);

	}

	@Test
	public void deleteProductByProductId() {
		System.out.println("Delete Product by ProductId");
		// given - precondition or setup
		given(productRepository.save(product1)).willReturn(product1);

		// When - action or behavior that we are going to test
		Product savedProduct = productServiceImpl.addProduct(product1);
		int deletedProduct = productServiceImpl.deleteProduct(savedProduct.getProductId());

		// then - verify the output
		assertThat(deletedProduct).isEqualTo(savedProduct.getProductId());
		System.out.println(productServiceImpl.deleteProduct(5));
//		assertThat(productServiceImpl.deleteProduct(5))
	}

}
