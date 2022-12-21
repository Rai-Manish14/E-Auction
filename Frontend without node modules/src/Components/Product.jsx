import React, { useContext } from 'react'
import { useNavigate } from 'react-router-dom'
import '../App.css'
import bidContext from '../Contexts/bidContext';
import productContext from '../Contexts/productContext';
import ProductService from '../Services/ProductService';
export default function Product() {

  const navigate = useNavigate();
  const productC = useContext(productContext)
  const bidC = useContext(bidContext)

  async function searchProduct(event) {
    event.preventDefault();
    var product = document.getElementById("searchProduct").value;
    if (product === "") {
      alert("Please enter a product")
    }
    else {
      product = product[0].toUpperCase(0) + product.substring(1);
      // console.log(product);

      var response = await ProductService.searchProduct(product)
      console.log("response data", response.data);

      var bidResponse = await ProductService.getAllBids(response.data.productId)
      console.log(bidResponse.data);

      if (bidResponse !== null) {
        bidC.updateBidData(bidResponse.data)
      }

      if (response !== null) {
        productC.updateProductData(
          response.data.productId,
          response.data.productName,
          response.data.shortDescription,
          response.data.detailedDescription,
          response.data.category,
          response.data.startingPrice,
          response.data.bidEndDate,
          response.data.firstName,
          response.data.lastName,
          response.data.address,
          response.data.city,
          response.data.state,
          response.data.pin,
          response.data.phone,
          response.data.email
        )
      }

      // console.log(productData);
      document.getElementById("productPageContent2").style.visibility = "visible"
    }
  }
  function goToAddProduct() {
    navigate("/addProduct")
  }
  function goToUpdateBid() {
    // console.log(bidC.state);
    navigate("/updateBid")
  }
  async function deleteProduct() {
    console.log(productC.state);
    var bidResponse = await ProductService.getAllBids(productC.state.productId)
    
    if (productC.state.productId !== undefined && bidResponse.data.length===0) {
      var response = await ProductService.deleteProduct(productC.state.productId)
      console.log(response);
      alert(response.data)
      document.getElementById("productPageContent2").style.visibility = "hidden"
    }
    else {
      alert("Product Cannot be deleted")
    }
  }
  var i = 1;
  const tableItems = bidC.state.length !== 0 ? bidC.state.map((item) =>
    <tr key={i++}>
      <td>{item.bidAmount}</td>
      <td>{item.firstName}{" "}{item.lastName}</td>
      <td>{item.phone}</td>
      <td>{item.email}</td>
      <td><button onClick={goToUpdateBid} id="updateBidBtn">Update Bid</button></td>
    </tr>
  ) : <tr><td style={{ backgroundColor: "rgba(43, 16, 1, 0.7)", border: "0.2vw solid black" }} colSpan={4}>No Bidding Placed</td></tr>
  return (
    <div className='productContainer'>
      <div id='productPageContent1'>
        <div>
          <input type="text" name="searchProduct" id="searchProduct" placeholder='Search Product....' />
          <input type="button" value="Search" className="productButtons" id='searchButton' onClick={searchProduct} />
          <input type="button" value="Add Product" className="productButtons" id='addProductButton' onClick={goToAddProduct} />
        </div>
      </div>
      <div id='productPageContent2' style={{ visibility: "hidden" }}>
        <div id="productDiv">
          <h4 id='productDetailHeader'>Product Details</h4>
          <div id='productDetails'>
            <table>
              <tbody>
                <tr>
                  <td>Product Id:</td>
                  <td>{productC.state.productId}</td>
                </tr>
                <tr>
                  <td>Product Name:</td>
                  <td>{productC.state.productName}</td>
                </tr>
                <tr>
                  <td>Short Description:</td>
                  <td>{productC.state.shortDescription}</td>
                </tr>
                <tr>
                  <td>Detailed Description:</td>
                  <td>{productC.state.detailedDescription}</td>
                </tr>
                <tr>
                  <td>Category:</td>
                  <td>{productC.state.category}</td>
                </tr>
                <tr>
                  <td>Starting Price:</td>
                  <td>{productC.state.startingPrice}</td>
                </tr>
                <tr>
                  <td>Bid End Date:</td>
                  <td>{productC.state.bidEndDate}</td>
                </tr>
              </tbody>
            </table>
          </div>
          <button id='deleteProductButton' onClick={deleteProduct}>Delete Product</button>
        </div>
        <div id="buyerDiv">
          <table>
            <thead>
              <tr>
                <th>Bidding Amount</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {tableItems}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}
