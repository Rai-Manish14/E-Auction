import React from 'react'
import { useNavigate } from 'react-router-dom';
import '../App.css'
import BuyerService from '../Services/BuyerService';
export default function Buyer() {
  const navigate = useNavigate();
  async function addBuyer(event) {
    event.preventDefault();

    const newBuyer = {
      "firstName": document.getElementById("firstName").value,
      "lastName": document.getElementById("lastName").value,
      "address": document.getElementById("Address").value,
      "city": document.getElementById("city").value,
      "state": document.getElementById("state").value,
      "pin": document.getElementById("pincode").value,
      "phone": document.getElementById("phoneNumber").value,
      "email": document.getElementById("email").value,
      "productId": document.getElementById("productId").value,
      "bidAmount": document.getElementById("biddingAmount").value
    }
    console.log(newBuyer);

    var response = await BuyerService.placeBid(newBuyer);
    if (response === "") {
      alert("Cannot place Bid")
    }
    else {
      console.log(response);
      alert("Bidding Placed Successfully")
      navigate("/")
    }
  }
  function goToHome() {
    navigate("/")
  }
  return (
    <div className='buyerContainer'>
      <form onSubmit={addBuyer}>
        <h4 id='sellerHeader'>Seller Details</h4>
        <div className='sellerForm'>
          <div className='leftDiv'>
            <div className='sellerDetails'>
              <label>Enter First Name:</label>
              <input className='inputFields' type="text" name="firstName" id="firstName" placeholder='Type Here...' minLength={5} maxLength={30} required/>
            </div>
            <div className='sellerDetails'>
              <label>Enter your City:</label>
              <input className='inputFields' type="text" name="city" id="city" placeholder='Type Here...' required/>
            </div>
            <div className='sellerDetails'>
              <label>Contact Number:</label>
              <input className='inputFields' type="number" name="phoneNumber" id="phoneNumber" placeholder='Type Here...' minLength={10} maxLength={10} required/>
            </div>
            <div className='sellerDetails'>
              <label>Enter Bidding Amount:</label>
              <input className='inputFields' type="number" name="biddingAmount" id="biddingAmount" placeholder='Type Here...' required/>
            </div>
          </div>
          <div className='centerDiv'>
            <div className='sellerDetails'>
              <label>Enter Last Name:</label>
              <input className='inputFields' type="text" name="lastName" id="lastName" placeholder='Type Here...' minLength={3} maxLength={25} required/>
            </div>
            <div className='sellerDetails'>
              <label>Enter your State:</label>
              <input className='inputFields' type="text" name="state" id="state" placeholder='Type Here...' required/>
            </div>
            <div className='sellerDetails'>
              <label>Enter your Email:</label>
              <input className='inputFields' type="email" name="email" id="email" placeholder='Type Here...' required/>
            </div>
            <div className='sellerDetails'>
              <button id='buyerSubmitButton1' onClick={goToHome}>Go Back</button>
              <button id='buyerSubmitButton2'>Place Bid</button>
            </div>
          </div>
          <div className='rightDiv'>
            <div className='sellerDetails'>
              <label>Enter your Address:</label>
              <input className='inputFields' type="text" name="address" id="Address" placeholder='Type Here...' required/>
            </div>
            <div className='sellerDetails'>
              <label>Enter your Pincode:</label>
              <input className='inputFields' type="text" name="pincode" id="pincode" placeholder='Type Here...' required/>
            </div>

            <div className='sellerDetails'>
              <label>Enter Product Id:</label>
              <input className='inputFields' type="text" name="productId" id="productId" placeholder='Type Here...' required/>
            </div>
          </div>
        </div>
      </form>
    </div>
  )
}
