import React from 'react'
import { useNavigate } from 'react-router-dom'
import BuyerService from '../Services/BuyerService';

export default function () {
  const navigate = useNavigate()
  function goBack() {
    navigate("/product")
  }
  async function updateBid(event) {
    event.preventDefault();
    var productId = document.getElementById("productId").value
    var email = document.getElementById("email").value
    var bidAmount = document.getElementById("bidAmount").value

    var response = await BuyerService.updateBid(productId, email, bidAmount)

    console.log(response);
    if (response!==""){
      alert(response.data)
      navigate("/product")
    }
  }
  return (
    <div class="updateBidContainer">
      <div id='updateBidFormContainer'>
        <h4 id='updateBidHeader'>Update your bidding</h4>
        <form onSubmit={updateBid} className='updateBidForm'>
          <div className='formInputs'>
            <div id='leftUpdateFormDiv'>
              <lable>Product Id:</lable>
              <lable>Email:</lable>
              <lable>New Bid Amount:</lable>
            </div>
            <div id='rightUpdateFormDiv'>
              <input type="number" className='updateBidInput' id='productId' required />
              <input type="text" className='updateBidInput' id='email' required />
              <input type="number" className='updateBidInput' id='bidAmount' required />
            </div>
          </div>
          <button className='updateBidButtons' onClick={goBack}>Go Back</button>
          <button className='updateBidButtons'>Update</button>
        </form>
      </div>
    </div>
  )
}
