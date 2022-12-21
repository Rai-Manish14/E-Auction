import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import AddProduct from './Components/AddProduct';
import Buyer from './Components/Buyer';
import HeaderComponent from './Components/HeaderComponent';
import HomePage from './Components/HomePage';
import Product from './Components/Product';
import UpdateBid from './Components/UpdateBid';
import BidState from './Contexts/BidState';
import ProductState from './Contexts/ProductState';

function App() {
  return (
    <ProductState>
      <BidState>
        <Router>
          <div id='mainContainer'>
            <HeaderComponent />
            <Routes>
              <Route path='/' element={<HomePage />} />
              <Route path='/product' element={<Product />} />
              <Route path='/addProduct' element={<AddProduct />} />
              <Route path='/updateBid' element={<UpdateBid />} />
              <Route path='/buyer' element={<Buyer />} />
            </Routes>
          </div>
        </Router>
      </BidState>
    </ProductState>
  );
}

export default App;
