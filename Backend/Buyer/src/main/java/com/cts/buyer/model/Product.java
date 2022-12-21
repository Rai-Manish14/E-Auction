package com.cts.buyer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Products")
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_id")
	@NotNull
	private int productId;
	
	@Column(name = "Product_Name")
	@NotEmpty
	private String productName;

	@Column(name = "Short_Description")
	@NotEmpty
	private String shortDescription;

	@Column(name = "Detailed_Description")
	@NotEmpty
	private String detailedDescription;

	@Column(name = "Category")
	@NotEmpty
	private String category;

	@Column(name = "Starting_Price")
	@NotNull
	private long startingPrice;

	@Column(name = "Bid_end_date")
	@NotEmpty
	private String bidEndDate;

	@Column(name = "Bid_amount")
	@NotNull
	private long bidAmount;

//	Seller Data

	@Column(name = "seller_id")
	@NotNull
	private int sellerId;

	@Column(name = "first_name")
	@NotEmpty
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty
	private String lastName;

	@Column(name = "Address")
	@NotEmpty
	private String address;

	@Column(name = "City")
	@NotEmpty
	private String city;

	@Column(name = "State")
	@NotEmpty
	private String state;

	@Column(name = "Pin")
	@NotNull
	private int pin;

	@Column(name = "Phone")
	@NotNull
	private long phone;

	@Column(name = "Email")
	@NotEmpty
	private String email;

}
