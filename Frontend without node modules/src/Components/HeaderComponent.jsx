import React from 'react'
import { useNavigate } from 'react-router-dom'

export default function Header() {
  const navigate = useNavigate()
  function goToHome() {
    navigate("/")
  }
  return (
    <div className='headerContainer'>
      <nav className='navbar navbar-dark navbar-expand-lg' id='navbarContainer'>
        <div className='navbar-brand' onClick={goToHome}>E-Auction</div>
        <div className='collapse navbar-collapse'>
        </div>
      </nav>
    </div>
  )
}
