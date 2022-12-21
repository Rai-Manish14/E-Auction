import React from 'react'
import { useNavigate } from 'react-router-dom'
import '../App.css'
export default function HomePage() {
  const navigate = useNavigate();
  function goToProduct() {
    navigate("/product");
  }
  function goToBuyer() {
    navigate("/buyer");
  }
  return (
    <div className='homePageBackground'>
      <div className='webInfo'>
        <span id='webInfo1'>Welcome to E-Auction</span>
      </div>
      <div className='webInfo'>
        <span id='webInfo2'>Place your biddings on your favourite products</span>
      </div>
      <div className='webInfo'>
        <div className='webInfoButton'>
          <button id='webInfoButton' onClick={goToProduct}>View Products</button>
          <button id='webInfoButton' onClick={goToBuyer}>Place Bidding</button>
          
        </div>
      </div>
    </div>
  )
}
