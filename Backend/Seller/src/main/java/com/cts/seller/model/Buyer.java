package com.cts.seller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Biddings")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buyer_id")
	@NotNull
	private int buyerId;

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
	
	@Column(name = "Product_Id")
	@NotNull
	private int productId;

	@Column(name = "Bid_Amount")
	@NotNull
	private long bidAmount;

}
